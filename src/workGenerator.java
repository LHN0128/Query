
import java.sql.Statement;
import java.util.concurrent.CountDownLatch;

/**
 * @author 刘冬燕
 *
 */
public class workGenerator implements Runnable {
	long javaTime;
	long startTime;
	long endTime;
	String sql;
	String DBurl = "";	//jdbc:postgresql://101.7.187.28:5432/postgres";
	String DBid;  //database id , 1GB = 12373;10GB = 17031
	double sf;//TPC-H SF因子
	Statement stmt = null;
	String user;	String pw; String userid;//用户名，密码，对象ID
	String Date;String elabel; int groupID; int threadID;int qid;int paraid;int  runNum;String snapFilePath;int buffer;
	private CountDownLatch latch;int DeltaTime;

	Runtime runtime=Runtime.getRuntime(); 
	getConnection conn ;
	QueryExecutor qExecutor;
	QueryText qText;
	SnapRecorder qSnap;
	
	public workGenerator(String Date,String DBurl,String DBid,double sf,String user,String pw,String userid,String elabel, int groupID, int threadID,int qid,int paraid,int  runNum,
			String snapFilePath, int buffer, CountDownLatch latch,int DeltaTime) {
		//数据库地址，数据库ID，TPCH SF,用户名，密码，用户名ID，实验标签，实验组号，线程号，qID，参数ID，运行次数，快照记录地址，缓冲池，锁，偏移时间
		this.Date = Date;this.DBurl = DBurl;this.DBid = DBid;this.sf = sf;this.user = user;this.pw = pw;this.userid = userid;
		this.elabel = elabel;this.groupID = groupID;this.threadID = threadID;this.qid = qid;this.paraid = paraid;
		this.runNum = runNum;this.snapFilePath = snapFilePath;this.buffer = buffer;this.latch = latch;this.DeltaTime = DeltaTime;
}
	private void initialize() throws Exception {
		conn = new getConnection();
		qExecutor = new QueryExecutor();
		qText = new QueryText(sf, DBid, userid);
		qSnap = new SnapRecorder(Date,DBid,elabel,threadID,buffer);
		stmt = conn.initStatement(DBurl, user, pw);
		qSnap.Initfile(snapFilePath);
	}
	private void close() throws Exception {
		conn.CloseConnection();
		qSnap.CloseFile();
	}
	
	
	private void work() throws Exception{
		for(int i = 0;i<runNum;i++){//内层循环为每个具体参数的查询运行次数
			System.out.println("threadID [ "+threadID+" ]----"+"QueryID [ "+qid+" ] ParaID [ "+(paraid+1)+" ] run ["+ (i+1) +"] times");
			sql=qText.getQueryString(qid, paraid);     //此sql为特定参数的特定查询
			System.out.println(sql);
			startTime=System.currentTimeMillis();
			qExecutor.ExecQuery(sql, stmt);        //选定查询后，真正开始执行的语句
			endTime=System.currentTimeMillis();
			qSnap.setQid(qid);
			//System.out.println(qText.getSnapString(qid));
			System.out.println(qText.getSnapString(qid));
			qSnap.getSnapShot(qExecutor.SnapQuery(qText.getSnapString(qid), stmt));//stmt语句对象执行前面qText.getSnapString(qid)这条语句
			javaTime=endTime-startTime;
			System.out.println(javaTime);
			qSnap.Recording(groupID, paraid, i+1, javaTime,DeltaTime);		//组别，参数id，运行次数，java时间,DeltaTime
		}
		//新增 
		//System.out.println("QueryID [ "+qid+" ] ParaID [ "+(paraid+1)+" ]spend["+(endTime-startTime)/1000+"]s");
	}
	
	public void finalize(){
		
	}
	public void run() {
			try {
				initialize();
				work();
				close();
				latch.countDown();           //每调用一次countdown()方法，计数器计数减1
				Thread.sleep(10000);
			} catch (Exception e) {
				e.printStackTrace();
			}		
	}
	
	
}
