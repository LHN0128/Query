import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.ResultSet;

public class SnapRecorder {
 
	double[][] result = new double[31][18];     //31个Query，18列参数,前三列不写入
	double[] temp = new double[18];//31个Query，18列参数,前三列不写入
	private File f;
	private Writer output = null;
	int qid;
	String DBid;
	String Date;
	String eLabel;
	int threadID;
	int buffer;
	public SnapRecorder(String Date,String DBid, String elabel, int threadID,int buffer){
		this.Date = Date;
		this.DBid = DBid;
		this.eLabel  = elabel;
		this.threadID=threadID;
		this.buffer = buffer;
	}
	public void Initfile(String Filepath) throws Exception {//set record File
		f = new File(Filepath);
		if(!f.exists()){f.createNewFile();}//如果文件不存在，则创建文件
		output = new FileWriter(f);
		output.write("日期,实验标签,始化组别,线程id,数据库id,线程运行次数,查询模板号,参数id,执行时间,blk_read_time,");
		output.write("\\r\\n");
		for(int i = 0;i<31;i++){//31个Query
			for(int j = 0;j<18;j++){//获取的参数列数
				temp[j] = 0;
				result[i][j] = 0;
				}
			}
		}
	public void CloseFile()throws Exception{
		output.close();
	}	
	public void setQid(int qid){
		this.qid = qid;
	}
	public  synchronized void getSnapShot(ResultSet rSnap)throws Exception{
		while(rSnap.next()){
			for(int i = 0;i<18;i++){//获取的参数列数
				temp[i] = rSnap.getDouble(i+1) - result[qid-1][i];
				result[qid-1][i] = rSnap.getDouble(i+1);
			}
		}
	}
	/*public  synchronized void getSnapShot(ResultSet rSnap)throws Exception{
		while(rSnap.next()){
			for(int i = 0;i<18;i++){//获取的参数列数
				temp[i] = rSnap.getDouble(i+1) - result[qid-1][i];
				result[qid-1][i] = rSnap.getDouble(i+1);
			}
		}
	}*/
	
	public void Recording(int groupID, int paraid,int runNum,long javaTime, int deltaTime) throws IOException{// output record to a txt file
		//组别，参数id，运行次数，java时间
		StringBuilder snapstr = new StringBuilder("");
		snapstr.append(Date +","+eLabel + "," +groupID+","+threadID+","+DBid+ ","+runNum+ ","+qid+","+(paraid+1)+","+javaTime+",");
		for(int i = 3; i < 18; i ++){//18列参数,前三列不写入
			snapstr.append(temp[i]);
			if(i != 17){snapstr.append(",");}
		}
		snapstr.append(","+buffer+","+deltaTime);
		
		output.write(snapstr.toString());
		output.write("\r\n");//to next line
	}
	
	

}
