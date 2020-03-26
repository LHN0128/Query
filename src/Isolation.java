import java.util.concurrent.CountDownLatch;

public class Isolation {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		String DBinfo[][] = {//数据库地址，数据库ID
				{"jdbc:postgresql://101.7.187.140:5432/postgres","12373"},
				{"jdbc:postgresql://101.7.187.26:5432/postgresql10G","16393"},
				{"jdbc:postgresql://101.7.187.43:5432/postgres10g","16421"}
		};
		String User[][] = {//用户名，用户名ID
				{"postgres","10"},{"user2","17135"},{"user3","17137"}
		};
		String pw = "pzf";
		int qTemp[] = {1,2,3,10,11,12,13,14,15,16,17,18};//查询模板         改这23,24,25,26,27,28,29,30,31
		//int paraLength[] = {30,30,30,30,30,30,25,30,30,24,25,30,16,30,0,30,30,4,30,30,25,30,1,1,1,1,1,1,1,1,1};//模板对应的参数总数，一共22个，此处查询编号为TPCH编号			
		int paraLength[] = {30,30,30,30,30,30,30,30,30,24,24,24,30,30,30,30,30,30,1,1,1,1,1,1,1,1,1};//模板对应的参数总数，一共18个，此处查询编号为TPCH编号
		//int qTemp[] = {4};//独立测试的模板
		int buffer=2000;//缓冲池大小，单位MB,试验参数1
		String Date = "190423";//试验日期,试验参数2
		String elabel = "SF10M1";//试验标签,试验参数3
		int runNum =30;//每个线程(即一个指定参数的查询)运行次数,试验参数4
		int paraMax = 1;//允许的最大参数个数,试验参数5
		int MPL=1;//并行程度,试验参数6
		int groupID = 1;   //初始化组别，可手动修改。试验参数7
		String snapFilePath = "F:\\PZF\\查询计划\\实验\\Rec\\Ios1\\";//快照地址,试验参数8
		double sf = 10;//sf因子,试验参数9
		double Fraction = 0.0001/sf;//Q11参数Fraction
		int threadID1=1;    //初始化线程号 
		double startTime;
		double endTime;
		double time;
		String snapFileName1;
		CountDownLatch latch;
		workGenerator work1;

		latch = new CountDownLatch(MPL);
		startTime=System.currentTimeMillis();
		
		for(int i = 0;i < qTemp.length;i ++){  //qTemp中第i个query,//外层循环为Query
			int paraNum;			
			if(qTemp[i] < 23){  //23之后的探针都为1个，也就是说，都是一个查询，参数不会变化
				if(paraLength[qTemp[i]-1] > paraMax){//如果参数个数大于paraMax，则参数循环最大为paraMax
					paraNum = paraMax;
				}else{
					paraNum = paraLength[qTemp[i]-1];
				}
			}else{
				paraNum = 1;
			}
			
			for(int j = 0;j<paraNum;j++){//内层循环为参数
				snapFileName1 = snapFilePath + elabel +"_"+groupID+"_"+threadID1+"_"+qTemp[i]+".txt";
				work1 = new workGenerator(Date,DBinfo[2][0],DBinfo[2][1],Fraction,User[0][0],pw,User[0][1],elabel,groupID,threadID1,qTemp[i],j,runNum,snapFileName1,buffer,latch,0);
				//试验日期,数据库地址，数据库ID，TPCH SF,用户名，密码，用户名ID，实验标签，实验组号，线程号，qID，参数ID，运行次数，快照记录地址，缓冲池，锁，偏移时间
				new Thread(work1).start();
				latch.await();
				work1 = null;
				latch = new CountDownLatch(MPL);
				groupID++;
			}		
		}
		endTime=System.currentTimeMillis();
		time=(endTime-startTime)/60000;
		System.out.println("Total Time is [ "+time +" ] Mins");
		
	}
}
