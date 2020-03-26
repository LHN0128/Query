import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;

 class tFlag{
		public static boolean FlagA = false;
		public static boolean FlagB = false;
}
public class MultiQueryGenerator implements Runnable {


	String sql;
	String DBurl = "";	//jdbc:postgresql://101.7.187.28:5432/postgres";
	String DBid;  //database id , 1GB = 12373;10GB = 17031
	double sf;//TPC-H SF因子
	Statement stmt = null;
	String user;	String pw;String userid;//用户名，密码，对象ID
	String Date;String elabel; int groupID; int threadID;int qid;int paraid;int  runNum;String snapFilePath;int buffer;
	private CountDownLatch latch;int DeltaTime;
	String sqlStartTime;
	Runtime runtime=Runtime.getRuntime(); 
	getConnection conn ;
	QueryExecutor qExecutor;
	QueryText qText;
	SnapRecorder qSnap;
	public MultiQueryGenerator(String Date,String DBurl,String DBid,double sf,String user,String pw,String userid,String elabel,int groupID,int threadID,int qid,int paraid,String snapFilePath, int buffer) {	
		//实验日期，数据库地址，数据库ID，TPCH SF，用户名，密码，用户名ID，实验标签，实验组号，线程号，qID，参数ID，快照记录地址，缓冲池
		this.Date = Date;this.DBurl = DBurl;this.DBid = DBid;this.sf = sf;this.user = user;this.pw = pw;this.userid = userid;
		this.elabel = elabel;this.groupID = groupID;this.threadID = threadID;this.qid = qid;this.paraid = paraid;this.snapFilePath = snapFilePath;this.buffer = buffer;
}
	
	private void initialize() throws Exception {
		conn = new getConnection();
		qExecutor = new QueryExecutor();
		qText = new QueryText(sf, DBid, userid);
		qSnap = new SnapRecorder(Date,DBid,elabel,threadID,buffer);
		stmt = conn.initStatement(DBurl, user, pw);
		qSnap.Initfile(snapFilePath);
	}

	public void SetDeltaT(int DeltaT) {
		this.DeltaTime = DeltaT;
	}
	public void SetLatch(CountDownLatch Latch) {
		this.latch = Latch;
	}
	public void SetRunNum(int runNum) {
		this.runNum = runNum;
	}

	public void workload()throws Exception{
		long javaTime;
		long startTime;
		long endTime;

		if((threadID != 1)){//非主线程sleep，参数是秒
			Thread.sleep(DeltaTime * 1000);
			System.out.println("threadID [ "+threadID+" ]----"+"Probe [ "+qid+" ] ParaID [ "+(paraid+1)+" ] start at " +DeltaTime+" sec");
		}else{
			System.out.println("threadID [ "+threadID+" ]----"+"Query [ "+qid+" ] ParaID [ "+(paraid+1)+" ] start");
		}
		sql=qText.getQueryString(qid, paraid);
			
		ResultSet rs = stmt.executeQuery("select localtimestamp");
		
		while(rs.next()){
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			sqlStartTime = df.format(rs.getTimestamp("timestamp"));
		}		
		startTime=System.currentTimeMillis();
		qExecutor.ExecQuery(sql, stmt);
		endTime=System.currentTimeMillis();
		qSnap.setQid(qid);
		//System.out.println(qText.getSnapString(qid));
		qSnap.getSnapShot(qExecutor.SnapQuery(qText.getSnapString(qid), stmt));
		javaTime=endTime-startTime;
		qSnap.Recording(groupID, paraid, runNum, javaTime,DeltaTime);		//组别，参数id，运行次数RunNum，java时间,DeltaTime
	}
	private void close() throws Exception {
		conn.CloseConnection();
		qSnap.CloseFile();
	}
	
	public void run(){
		try {
		//	Initalize();
			workload();
			latch.countDown();
		//	Close();
		} catch (Exception e) {
			e.printStackTrace();
			}
		}
	public static void main(String[] args) throws Exception{
		int qTemp[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,16,18,19,21,22,23,24,25,26,27,28,29,30,31};//查询模板,probe序号为19-qTemp.lenght1,2,3,4,5,6,7,8,9,10,11,12,13,14,16,18,19,21,22,23,24,25,26,27,28,29,30,31
		int paraLength[] = {3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,1,1,1,1,1,1,1,1,1};//模板对应的参数总数，此处查询编号为TPCH编号	30,30,30,30,30,30,25,30,30,24,25,30,16,30,0,30,30,4,30,30,25,30,9,1,1,1,1,1,1,1,1	
		String DBinfo[][] = {//数据库地址，数据库ID
				{"jdbc:postgresql://101.7.187.140:5432/postgres","12373"},
				{"jdbc:postgresql://101.7.187.140:5432/postgres10G","17031"},
				{"jdbc:postgresql://101.7.187.195:5432/postgres10G","16384"}
		};
		String User[][] = {//用户名，用户名ID
				/*{"user1","17136"},{"user2","17135"},{"user3","17137"}*/
				{"postgres","10"},{"user2","17135"},{"user3","17137"}
		};
		String pw = "123";
		String fileType = ".txt";
		int buffer=1024;//缓冲池大小，单位MB,试验参数1
		String Date = "170914";//试验日期,试验参数2
		String elabel = "Probe";//试验标签,试验参数3
		int runNum =5;//每个线程运行次数,试验参数4
		int MPL=2;//并行程度,试验参数6
		int groupID = 1;//初始化组别,试验参数7
		String snapFilePath = "F:\\pzfdata\\10G\\probe-data\\Para\\";//快照地址,试验参数8
		double sf = 10;//sf因子,试验参数9	
		double Fraction = 0.0001/sf;//Q11参数Fraction,试验参数10
		final int endTime = 15;//最长时间差,试验参数11
		final int DeltaTime = 1;//时间差进步值,为0时两线程同时运行。试验参数12
		CountDownLatch Latch;
		final int thread1 = 1;
		final int thread2 = 2;
		MultiQueryGenerator work1;
		MultiQueryGenerator work2;
		int T1pointer = 0;
		int T2pointer = 0;
		double startTime;
		double allTime;
		double spendTime;
		startTime=System.currentTimeMillis();
		for(T1pointer = 0;T1pointer<19;T1pointer++){//前1-18个是主查询，19之后是probe
			for(T2pointer = 19;T2pointer<qTemp.length;T2pointer++){
				for(int paraID_1 = 0;paraID_1 < paraLength[qTemp[T1pointer]-1];paraID_1++){//主查询参数循环
					for(int paraID_2 = 0;paraID_2 < paraLength[qTemp[T2pointer]-1];paraID_2++){//probe参数循环
						String Spath1 = snapFilePath+elabel+"_"+String.valueOf(groupID)+"_"+"_T1"+fileType;
						String Spath2 = snapFilePath+elabel+"_"+String.valueOf(groupID)+"_"+"_T2"+fileType;
						//实验日期，数据库地址，数据库ID，TPCH SF，用户名，密码，用户名ID，实验标签，线程号，qID，参数ID，快照记录地址，缓冲池
						work1 = new MultiQueryGenerator(Date,DBinfo[2][0],DBinfo[2][1],Fraction,User[0][0],pw,User[0][1],elabel,groupID,thread1,qTemp[T1pointer],paraID_1,Spath1,buffer);
						work2 = new MultiQueryGenerator(Date,DBinfo[2][0],DBinfo[2][1],Fraction,User[0][0],pw,User[0][1],elabel,groupID,thread2,qTemp[T2pointer],paraID_2,Spath2,buffer);
						work1.initialize();
						work2.initialize();
						//for(int time = 0;time < endTime;time =  time + DeltaTime){//探测时间间隔为1s
							int time = 0;//delta为0设置	
							work1.SetDeltaT(time);
							work2.SetDeltaT(time);
							System.out.println("Main Query: [" +qTemp[T1pointer] +" ] and Probe ["+qTemp[T2pointer]+"]  with DeltaTime  : " + time);	
							for(int i = 0;i<runNum;i++){
								Latch = new CountDownLatch(MPL);
								work1.SetLatch(Latch);
								work2.SetLatch(Latch);
								work1.SetRunNum(i);
								work2.SetRunNum(i);
								Thread QueryT = new Thread(work1);
								Thread ProbeT = new Thread(work2);
								Thread.sleep(1000);//主线程暂停1s等待代码运行同步
								QueryT.start();
								ProbeT.start();
								Latch.await();
								QueryT = null;
								ProbeT = null;
								Latch = null;
								}
								System.out.println("Test Next DeltaTime is: " + time );
							//}
						groupID++;
						Thread.sleep(1000);
						work1.close();
						work2.close();
						System.gc();
						
						//用来输出实验运行配对情况。
/*						System.out.println("Main Query: " + qTemp[T1pointer]+
								", Probe Query: "+qTemp[T2pointer] + "ParaID: " 
								+ (paraID_1 + 1)+" , "+
								(paraID_2 + 1));*/
					}
				}		
			}
		}
		allTime=System.currentTimeMillis();
		spendTime=(allTime-startTime)/60000;
		System.out.println("Total Time is [ "+spendTime +" ] Mins");
	}
	
}



/*import java.util.concurrent.CountDownLatch;


public class MultiQueryGenerator {
	public static void main(String[] args) throws InterruptedException {
		String DBinfo[][] = {  //数据库地址，数据库ID
				{"jdbc:postgresql://101.7.187.140:5432/postgres","12373"},
				{"jdbc:postgresql://101.7.187.26:5432/postgresql10G","16393"},
				{"jdbc:postgresql://101.7.187.195:5432/postgres10G","16384"}
		};
		String User[][] = {//用户名，用户名ID
				{"postgres","10"},{"user2","17135"},{"user3","17137"}
		};
		String pw = "123";
		int qTemp[] = {1,23};//查询模板          改这1,2,3,4,5,6,7,8,9,10,11,12,13,14,16,18,19,21,22,23,24,25,26,27,28,29,30,31
		int paraLength[] = {30,30,30,30,30,30,25,30,30,24,25,30,16,30,0,30,30,4,30,30,25,30,9};//模板对应的参数总数，一共23个，此处查询编号为TPCH编号			
		//int qTemp[] = {14,19};//独立测试的模板            
		int buffer=1024;//缓冲池大小，单位MB,试验参数1
		String Date = "170815";//试验日期,试验参数2
		String elabel = "Para1";//试验标签,试验参数3
		int runNum =2;//每个线程(即指定特定参数的查询)运行次数,试验参数4
		int paraMax = 1;//允许的最大参数个数,试验参数5
		int MPL=2;//并行程度,试验参数6
		int groupID =1;   //始化组别，可手动修改。试验参数7   改这
		String snapFilePath = "F:\\pzfdata\\10G\\probe-data\\Para\\";;//快照地址,试验参数8
		double sf = 1;//sf因子,试验参数9
		double Fraction = 0.0001/sf;//Q11参数Fraction
		int threadID1=1;    //初始化线程号
		int threadID2=2;
		double startTime;
		double endTime;
		double time;
		String snapFileName1;
		String snapFileName2;
		CountDownLatch latch;
		workGenerator work1;
		workGenerator work2;

		latch = new CountDownLatch(MPL);
		startTime=System.currentTimeMillis();
		
		//int j=0;
		//int i3=0;
		
		for(int i = 0;i < qTemp.length;i++){  //qTemp中第i个query,//外层循环为Query
			//for(j=i+1;j<qTemp.length;j++){
			for(int j = 0 ;j<qTemp.length;j++){	
				snapFileName1 = snapFilePath + elabel +"_"+groupID+"_"+threadID1+"_"+qTemp[i]+"_"+"T1"+".txt";
				snapFileName2=snapFilePath+elabel+"_"+groupID+"_"+threadID2+"_"+qTemp[j]+"_"+"T2"+".txt";
				work1 = new workGenerator(Date,DBinfo[2][0],DBinfo[2][1],Fraction,User[0][0],pw,User[0][1],elabel,groupID,threadID1,qTemp[i],j,runNum,snapFileName1,buffer,latch,0);
				//试验日期,数据库地址，数据库ID，TPCH SF,用户名，密码，用户名ID，实验标签，实验组号，线程号，qID，参数ID，运行次数，快照记录地址，缓冲池，锁，偏移时间
				// work1 = new workGenerator(Date,DBinfo[1][0],DBinfo[1][1],Fraction,User[0][0],pw,User[0][1],elabel,groupID,threadID1,qTemp[i],j,runNum,snapFileName1,buffer,latch,0);
				work2=new workGenerator(Date,DBinfo[2][0],DBinfo[2][1],Fraction,User[0][0],pw,User[0][1],elabel,groupID,threadID2,qTemp[i+1],j,runNum,snapFileName2,buffer,latch,0); 
				new Thread(work1).start();
				new Thread(work2).start();
				latch.await();           //计数器大于0，此方法会阻塞程序继续执行
				//work1 = null;
				latch = new CountDownLatch(MPL);       
				groupID++;
				
			}
			
			int paraNum;			
			if(qTemp[i] < 24){  //23之后的探针都为1个，也就是说，都是一个查询，参数不会变化
				if(paraLength[qTemp[i]-1] > paraMax){//如果参数个数大于paraMax，则参数循环最大为paraMax
					paraNum = paraMax;
				}else{
					paraNum = paraLength[qTemp[i]-1];
				}
			}else{
				paraNum = 1;
			}
			
			
			
				
					
		}
		
		
		
		endTime=System.currentTimeMillis();
		time=(endTime-startTime)/60000;
		System.out.println("Total Time is [ "+time +" ] Mins");
	}

}
*/