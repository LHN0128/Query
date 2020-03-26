import java.util.concurrent.CountDownLatch;


public class ThreeQueryGenerator {
	
	public static void main(String[] args) throws InterruptedException {
		String DBinfo[][] = {//数据库地址，数据库ID
				{"jdbc:postgresql://101.7.187.140:5432/postgres","12373"},
				{"jdbc:postgresql://101.7.187.26:5432/postgresql10G","16393"},
				{"jdbc:postgresql://101.7.187.43:5432/postgres10g","16421"}
		};
		String User[][] = {//用户名，用户名ID
				{"postgres","10"},{"user2","17135"},{"user3","17137"}
		};
		String pw = "pzf";
		int qTemp[] = {1,2,3,10,11,12,13,14,15,16,17,18};//查询模板          改这  2,4,5,6,9,14,16,18,19
		//int paraLength[] = {30,30,30,30,30,30,25,30,30,24,25,30,16,30,0,30,30,4,30,30,25,30,9};//模板对应的参数总数，一共23个，此处查询编号为TPCH编号			
		int paraLength[] = {30,30,30,30,30,30,30,30,30,24,24,24,30,30,30,30,30,30,1,1,1,1,1,1,1,1,1};//模板对应的参数总数，一共18个，此处查询编号为TPCH编号
		//int qTemp[] = {14,19};//独立测试的模板
		int buffer=2000;//缓冲池大小，单位MB,试验参数1
		String Date = "190426";//试验日期,试验参数2
		String elabel = "SF10M3";//试验标签,试验参数3
		int runNum =30;//每个线程(即指定特定参数的查询)运行次数,试验参数4
		int paraMax = 1;//允许的最大参数个数,试验参数5
		int MPL=3;//并行程度,试验参数6
		int groupID =1;   //始化组别，可手动修改。试验参数7   改这
		String snapFilePath = "F:\\PZF\\查询计划\\实验\\Rec\\Con3\\";//快照地址,试验参数8
		double sf = 10;//sf因子,试验参数9
		double Fraction = 0.0001/sf;//Q11参数Fraction
		int threadID1=1;    //初始化线程号
		int threadID2=2;
		int threadID3=3;
		double startTime;
		double endTime;
		double time;
		String snapFileName1;
		String snapFileName2;
		String snapFileName3;
		CountDownLatch latch;
		workGenerator work1;
		workGenerator work2;
		workGenerator work3;
		latch = new CountDownLatch(MPL);
		startTime=System.currentTimeMillis();
		
		int ii=0;
		//int i3=0;
		int iii=0;
		for(int i = 0;i < qTemp.length;i ++){  //qTemp中第i个query,//外层循环为Query
			for(ii=i+1;ii<qTemp.length;ii++){
				for(iii=ii+1;iii<qTemp.length;iii++){
					snapFileName1 = snapFilePath + elabel +"_"+groupID+"_"+threadID1+"_"+qTemp[i]+".txt";
					snapFileName2=snapFilePath+elabel+"_"+groupID+"_"+threadID2+"_"+qTemp[ii]+".txt";
					snapFileName3=snapFilePath+elabel+"_"+groupID+"_"+threadID3+"_"+qTemp[iii]+".txt";
					work1 = new workGenerator(Date,DBinfo[2][0],DBinfo[2][1],Fraction,User[0][0],pw,User[0][1],elabel,groupID,threadID1,qTemp[i],0,runNum,snapFileName1,buffer,latch,0);
					//试验日期,数据库地址，数据库ID，TPCH SF,用户名，密码，用户名ID，实验标签，实验组号，线程号，qID，参数ID，运行次数，快照记录地址，缓冲池，锁，偏移时间
					// work1 = new workGenerator(Date,DBinfo[1][0],DBinfo[1][1],Fraction,User[0][0],pw,User[0][1],elabel,groupID,threadID1,qTemp[i],j,runNum,snapFileName1,buffer,latch,0);
					work2=new workGenerator(Date,DBinfo[2][0],DBinfo[2][1],Fraction,User[0][0],pw,User[0][1],elabel,groupID,threadID2,qTemp[ii],0,runNum,snapFileName2,buffer,latch,0); 
					work3=new workGenerator(Date,DBinfo[2][0],DBinfo[2][1],Fraction,User[0][0],pw,User[0][1],elabel,groupID,threadID3,qTemp[iii],0,runNum,snapFileName3,buffer,latch,0); 
					new Thread(work1).start();
					new Thread(work2).start();
					new Thread(work3).start();
					latch.await();
					work1 = null;
					latch = new CountDownLatch(MPL);
					groupID++;
				}
			}
			
			/*int paraNum;			
			if(qTemp[i] < 24){  //23之后的探针都为1个，也就是说，都是一个查询，参数不会变化
				if(paraLength[qTemp[i]-1] > paraMax){//如果参数个数大于paraMax，则参数循环最大为paraMax
					paraNum = paraMax;
				}else{
					paraNum = paraLength[qTemp[i]-1];
				}
			}else{
				paraNum = 1;
			}*/
			
			
			
				
					
		}
		
		
		
		endTime=System.currentTimeMillis();
		time=(endTime-startTime)/60000;
		System.out.println("Total Time is [ "+time +" ] Mins");
	}

}
