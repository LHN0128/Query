import java.io.*;

public class ParameterExtractor {
	private File inputFile = null;
	private InputStreamReader reader = null;
	private BufferedReader bReader = null;
	private String[] filelist = null;
	private File paraWriter;
	private Writer outputfile = null;
	
	public ParameterExtractor(String parawriterPath)throws Exception {
		// TODO Auto-generated constructor stub
		paraWriter = new File( parawriterPath);
		if(!paraWriter.exists()){paraWriter.createNewFile();}//如果文件不存在，则创建文件
		outputfile = new FileWriter(paraWriter);
	}
	public void CloseFile()throws Exception{
		outputfile.close();
	}	
	public void getPara(String filepath)throws Exception{
		filelist = getFileName(filepath);
		for(int i = 0;i<filelist.length;i++){
			System.out.println("---------------------The Paramater in " +i+" th file is : -----------------" );
			extractor(filepath + filelist[i],(i+1));
			
		}
	}
    public  String[]  getFileName(String filepath)
    {
        File file = new File(filepath);
        String [] fileName = file.list();
        return fileName;
    }
	public void extractor(String filepathName,int fileID)throws Exception{//抽取filepathName文本中的参数
		String txt = null;
		String paraStr = null;
		String paraStr1 = null;
		String paraStr2 = null;
		String paraStr3 = null;
		String paraStr4 = null;
		String paraStr5 = null;
		int RowID = 1;
		inputFile = new File(filepathName);
		reader = new InputStreamReader(new FileInputStream(inputFile));
		bReader = new BufferedReader(reader);
		if((txt = bReader.readLine()) != null){
			while(RowID != 18){//获取Q1第18行文本
				RowID ++;
				txt = bReader.readLine();
			}
			System.out.print("QueryID is 1 and Line ID : " + RowID +" , the string is : "+txt);
			paraStr = txt.substring(txt.indexOf("'",40) + 1, txt.lastIndexOf("'"));//获取Q1第18行文本的参数
			System.out.println(" , the Parameter  is : " + paraStr);
			outputfile.write(fileID+", 1 , 18 ,"+paraStr);//写入列为文本号，查询号，行号，参数
			outputfile.write("\r\n");
			
			while(RowID != 46){//获取Q2第46行文本
				RowID ++;
				txt = bReader.readLine();
			}
			System.out.print("QueryID is 2 and Line ID : " + RowID +" , the string is : "+txt);
			paraStr = txt.substring(txt.indexOf("=") + 1);//获取Q2第46行文本的参数
			System.out.println(" , the Parameter  is : " + paraStr);

			
			while(RowID != 47){//获取Q2第47行文本
				RowID ++;
				txt = bReader.readLine();
			}
			System.out.print("QueryID is 2 and Line ID : " + RowID +" , the string is : "+txt);
			paraStr1 = txt.substring(txt.indexOf("%") + 1,txt.indexOf("'",19));//获取Q2第47行文本的参数
			System.out.println(" , the Parameter  is : " + paraStr1);
			
			while(RowID != 50){//获取Q2第50行文本
				RowID ++;
				txt = bReader.readLine();
			}
			System.out.print("QueryID is 2 and Line ID : " + RowID +" , the string is : "+txt);
			paraStr2 = txt.substring(txt.indexOf("'") + 1,txt.length()-1);//获取Q2第50行文本的参数
			System.out.println(" , the Parameter  is : " + paraStr2);
		}
		outputfile.write(fileID+", 2 , 46-50 ,"+paraStr+","+paraStr1+","+paraStr2);//写入列为文本号，查询号，行号，参数
		outputfile.write("\r\n");
		
		while(RowID != 84){//获取Q3第84行文本
			RowID ++;
			txt = bReader.readLine();
		}
		System.out.print("QueryID is 3 and Line ID : " + RowID +" , the string is : "+txt);
		paraStr = txt.substring(txt.indexOf("'") + 1,txt.length()-1);//获取Q3第84行文本的参数
		System.out.println(" , the Parameter  is : " + paraStr);
		
		while(RowID != 87){//获取Q3第87行文本
			RowID ++;
			txt = bReader.readLine();
		}
		System.out.print("QueryID is 3 and Line ID : " + RowID +" , the string is : "+txt);
		paraStr1 = txt.substring(txt.indexOf("'") + 1,txt.length()-1);//获取Q3第87行文本的参数
		System.out.println(" , the Parameter  is : " + paraStr1);
		outputfile.write(fileID+", 3 , 84-87 ,"+paraStr+","+paraStr1);//写入列为文本号，查询号，行号，参数
		outputfile.write("\r\n");
		
		while(RowID != 105){//获取Q4第105行文本
			RowID ++;
			txt = bReader.readLine();
		}
		System.out.print("QueryID is 4 and Line ID : " + RowID +" , the string is : "+txt);
		paraStr = txt.substring(txt.indexOf("'") + 1,txt.length()-1);//获取Q4第105行文本的参数
		System.out.println(" , the Parameter  is : " + paraStr);
		outputfile.write(fileID+", 4 , 105 ,"+paraStr);//写入列为文本号，查询号，行号，参数
		outputfile.write("\r\n");
		
		while(RowID != 140){//获取Q5第140行文本
			RowID ++;
			txt = bReader.readLine();
		}
		System.out.print("QueryID is 5 and Line ID : " + RowID +" , the string is : "+txt);
		paraStr = txt.substring(txt.indexOf("'") + 1,txt.length()-1);//获取Q5第140行文本的参数
		System.out.println(" , the Parameter  is : " + paraStr);
		
		while(RowID != 141){//获取Q5第141行文本
			RowID ++;
			txt = bReader.readLine();
		}
		System.out.print("QueryID is 5 and Line ID : " + RowID +" , the string is : "+txt);
		paraStr1 = txt.substring(txt.indexOf("'") + 1,txt.length()-1);//获取Q5第141行文本的参数
		System.out.println(" , the Parameter  is : " + paraStr1);
		outputfile.write(fileID+", 5 , 140-141 ,"+paraStr+","+paraStr1);//写入列为文本号，查询号，行号，参数
		outputfile.write("\r\n");
		
		while(RowID != 155){//获取Q6第155行文本
			RowID ++;
			txt = bReader.readLine();
		}
		System.out.print("QueryID is 6 and Line ID : " + RowID +" , the string is : "+txt);
		paraStr = txt.substring(txt.indexOf("'") + 1,txt.length()-1);//获取Q6第155行文本的参数
		System.out.println(" , the Parameter  is : " + paraStr);
		
		while(RowID != 157){//获取Q6第157行文本
			RowID ++;
			txt = bReader.readLine();
		}
		System.out.print("QueryID is 6 and Line ID : " + RowID +" , the string is : "+txt);
		paraStr1 = txt.substring(24,28);//获取Q6第157行文本的参数
		System.out.println(" , the Parameter  is : " + paraStr1);
		
		while(RowID != 158){//获取Q6第158行文本
			RowID ++;
			txt = bReader.readLine();
		}
		System.out.print("QueryID is 6 and Line ID : " + RowID +" , the string is : "+txt);
		paraStr2 = txt.substring(txt.indexOf("<") + 1,txt.length()-1);//获取Q6第158行文本的参数
		System.out.println(" , the Parameter  is : " + paraStr2);
		outputfile.write(fileID+", 6 , 155-158 ,"+paraStr+","+paraStr1+","+paraStr2);//写入列为文本号，查询号，行号，参数
		outputfile.write("\r\n");
		
		while(RowID != 188){//获取Q7第188行文本
			RowID ++;
			txt = bReader.readLine();
		}
		System.out.print("QueryID is 7 and Line ID : " + RowID +" , the string is : "+txt);
		paraStr = txt.substring(txt.indexOf("'") + 1,txt.indexOf("'",19));//获取Q7第188行文本的参数
		System.out.println(" , the Parameter  is : " + paraStr);
		
		while(RowID != 189){//获取Q7第189行文本
			RowID ++;
			txt = bReader.readLine();
		}
		System.out.print("QueryID is 7 and Line ID : " + RowID +" , the string is : "+txt);
		paraStr1 = txt.substring(txt.indexOf("'") + 1,txt.indexOf("'",21));//获取Q7第189行文本的参数
		System.out.println(" , the Parameter  is : " + paraStr1);
		outputfile.write(fileID+", 7 , 188-189 ,"+paraStr+","+paraStr1);//写入列为文本号，查询号，行号，参数
		outputfile.write("\r\n");
		
		while(RowID != 207){//获取Q8第207行文本
			RowID ++;
			txt = bReader.readLine();
		}
		System.out.print("QueryID is 8 and Line ID : " + RowID +" , the string is : "+txt);
		paraStr = txt.substring(txt.indexOf("'") + 1,txt.indexOf("'",18));//获取Q8第207行文本的参数
		System.out.println(" , the Parameter  is : " + paraStr);
		
		while(RowID != 232){//获取Q8第232行文本
			RowID ++;
			txt = bReader.readLine();
		}
		System.out.print("QueryID is 8 and Line ID : " + RowID +" , the string is : "+txt);
		paraStr1 = txt.substring(txt.indexOf("'") + 1,txt.length()-1);//获取Q8第232行文本的参数
		System.out.println(" , the Parameter  is : " + paraStr1);
		
		while(RowID != 235){//获取Q8第235行文本
			RowID ++;
			txt = bReader.readLine();
		}
		System.out.print("QueryID is 8 and Line ID : " + RowID +" , the string is : "+txt);
		paraStr2 = txt.substring(txt.indexOf("'") + 1,txt.length()-1);//获取Q8第235行文本的参数
		System.out.println(" , the Parameter  is : " + paraStr2);
		outputfile.write(fileID+", 8 , 207-235 ,"+paraStr+","+paraStr1+","+paraStr2);//写入列为文本号，查询号，行号，参数
		outputfile.write("\r\n");
		
		while(RowID != 268){//获取Q9第268行文本
			RowID ++;
			txt = bReader.readLine();
		}
		System.out.print("QueryID is 9 and Line ID : " + RowID +" , the string is : "+txt);
		paraStr = txt.substring(txt.indexOf("%") + 1,txt.length()-2);//获取Q9第268行文本的参数
		System.out.println(" , the Parameter  is : " + paraStr);
		outputfile.write(fileID+", 9 , 268 ,"+paraStr);//写入列为文本号，查询号，行号，参数
		outputfile.write("\r\n");
		
		while(RowID != 296){//获取Q10第296行文本
			RowID ++;
			txt = bReader.readLine();
		}
		System.out.print("QueryID is 10 and Line ID : " + RowID +" , the string is : "+txt);
		paraStr = txt.substring(txt.indexOf("'") + 1,txt.length()-1);//获取Q10第296行文本的参数
		System.out.println(" , the Parameter  is : " + paraStr);
		outputfile.write(fileID+", 10 , 296 ,"+paraStr);//写入列为文本号，查询号，行号，参数
		outputfile.write("\r\n");
		
		while(RowID != 323){//获取Q11第323行文本
			RowID ++;
			txt = bReader.readLine();
		}
		System.out.print("QueryID is 11 and Line ID : " + RowID +" , the string is : "+txt);
		paraStr = txt.substring(txt.indexOf("'") + 1,txt.length()-1);//获取Q11第323行文本的参数
		System.out.println(" , the Parameter  is : " + paraStr);
		outputfile.write(fileID+", 11 , 323 ,"+paraStr);//写入列为文本号，查询号，行号，参数
		outputfile.write("\r\n");
		
		while(RowID != 362){//获取Q12第362行文本
			RowID ++;
			txt = bReader.readLine();
		}
		System.out.print("QueryID is 12 and Line ID : " + RowID +" , the string is : "+txt);
		paraStr = txt.substring(txt.indexOf("'") + 1,txt.length()-2);//获取Q12第362行文本的参数
		System.out.println(" , the Parameter  is : " + paraStr);
		
		while(RowID != 365){//获取Q12第365行文本
			RowID ++;
			txt = bReader.readLine();
		}
		System.out.print("QueryID is 12 and Line ID : " + RowID +" , the string is : "+txt);
		paraStr1 = txt.substring(txt.indexOf("'") + 1,txt.length()-1);//获取Q12第365行文本的参数
		System.out.println(" , the Parameter  is : " + paraStr1);
		outputfile.write(fileID+", 12 , 362-365 ,"+paraStr + ","+paraStr1);//写入列为文本号，查询号，行号，参数
		outputfile.write("\r\n");
		
		while(RowID != 408){//获取Q14第408行文本
			RowID ++;
			txt = bReader.readLine();
		}
		System.out.print("QueryID is 14 and Line ID : " + RowID +" , the string is : "+txt);
		paraStr = txt.substring(txt.indexOf("'") + 1,txt.length()-1);//获取Q14第408行文本的参数
		System.out.println(" , the Parameter  is : " + paraStr);
		outputfile.write(fileID+", 14 , 408 ,"+paraStr);//写入列为文本号，查询号，行号，参数
		outputfile.write("\r\n");
		
		while(RowID != 419){//获取Q15第408行文本
			RowID ++;
			txt = bReader.readLine();
		}
		System.out.print("QueryID is 15 and Line ID : " + RowID +" , the string is : "+txt);
		paraStr = txt.substring(txt.indexOf("'") + 1,txt.length()-1);//获取Q15第419行文本的参数
		System.out.println(" , the Parameter  is : " + paraStr);
		outputfile.write(fileID+", 15 , 419 ,"+paraStr);//写入列为文本号，查询号，行号，参数
		outputfile.write("\r\n");
		
		while(RowID != 459){//获取Q16第459行文本
			RowID ++;
			txt = bReader.readLine();
		}
		System.out.print("QueryID is 16 and Line ID : " + RowID +" , the string is : "+txt);
		paraStr = txt.substring(txt.indexOf("'") + 1,txt.length()-1);//获取Q16第459行文本的参数
		System.out.println(" , the Parameter  is : " + paraStr);
		
		while(RowID != 460){//获取Q16第459行文本
			RowID ++;
			txt = bReader.readLine();
		}
		System.out.print("QueryID is 16 and Line ID : " + RowID +" , the string is : "+txt);
		paraStr1 = txt.substring(txt.indexOf("'") + 1,txt.length()-2);//获取Q16第460行文本的参数
		System.out.println(" , the Parameter  is : " + paraStr1);
		
		while(RowID != 461){//获取Q16第461行文本
			RowID ++;
			txt = bReader.readLine();
		}
		System.out.print("QueryID is 16 and Line ID : " + RowID +" , the string is : "+txt);
		paraStr2 = txt.substring(txt.indexOf("(") + 1,txt.length()-1);//获取Q16第461行文本的参数
		System.out.println(" , the Parameter  is : " + paraStr2);
		outputfile.write(fileID+", 16 , 459-461 ,"+paraStr + "," +paraStr1 + "," +paraStr2);//写入列为文本号，查询号，行号，参数
		outputfile.write("\r\n");
		
		while(RowID != 489){//获取Q17第489行文本
			RowID ++;
			txt = bReader.readLine();
		}
		System.out.print("QueryID is 17 and Line ID : " + RowID +" , the string is : "+txt);
		paraStr = txt.substring(txt.indexOf("'") + 1,txt.length()-1);//获取Q17第489行文本的参数
		System.out.println(" , the Parameter  is : " + paraStr);
		
		while(RowID != 490){//获取Q17第490行文本
			RowID ++;
			txt = bReader.readLine();
		}
		System.out.print("QueryID is 17 and Line ID : " + RowID +" , the string is : "+txt);
		paraStr1 = txt.substring(txt.indexOf("'") + 1,txt.length()-1);//获取Q17第490行文本的参数
		System.out.println(" , the Parameter  is : " + paraStr1);
		outputfile.write(fileID+", 17 , 489-490 ,"+paraStr + "," +paraStr1);//写入列为文本号，查询号，行号，参数
		outputfile.write("\r\n");
		
		while(RowID != 545){//获取Q19第545行文本
			RowID ++;
			txt = bReader.readLine();
		}
		System.out.print("QueryID is 19 and Line ID : " + RowID +" , the string is : "+txt);
		paraStr = txt.substring(txt.indexOf("'") + 1,txt.length()-1);//获取Q19第545行文本的参数
		System.out.println(" , the Parameter  is : " + paraStr);
		
		while(RowID != 547){//获取Q19第547行文本
			RowID ++;
			txt = bReader.readLine();
		}
		System.out.print("QueryID is 19 and Line ID : " + RowID +" , the string is : "+txt);
		paraStr1 = txt.substring(txt.indexOf("=") + 2,txt.indexOf("=") + 4);//获取Q19第547行文本的参数
		System.out.println(" , the Parameter  is : " + paraStr1);

		while(RowID != 555){//获取Q19第555行文本
			RowID ++;
			txt = bReader.readLine();
		}
		System.out.print("QueryID is 19 and Line ID : " + RowID +" , the string is : "+txt);
		paraStr2 = txt.substring(txt.indexOf("'") + 1,txt.length()-1);//获取Q19第555行文本的参数
		System.out.println(" , the Parameter  is : " + paraStr2);
		
		while(RowID != 557){//获取Q19第557行文本
			RowID ++;
			txt = bReader.readLine();
		}
		System.out.print("QueryID is 19 and Line ID : " + RowID +" , the string is : "+txt);
		paraStr3 = txt.substring(txt.indexOf("=") + 2,txt.indexOf("=") + 4);//获取Q19第557行文本的参数
		System.out.println(" , the Parameter  is : " + paraStr3);
		
		while(RowID != 565){//获取Q19第565行文本
			RowID ++;
			txt = bReader.readLine();
		}
		System.out.print("QueryID is 19 and Line ID : " + RowID +" , the string is : "+txt);
		paraStr4 = txt.substring(txt.indexOf("'") + 1,txt.length()-1);//获取Q19第565行文本的参数
		System.out.println(" , the Parameter  is : " + paraStr4);
		
		while(RowID != 567){//获取Q19第567行文本
			RowID ++;
			txt = bReader.readLine();
		}
		System.out.print("QueryID is 19 and Line ID : " + RowID +" , the string is : "+txt);
		paraStr5 = txt.substring(txt.indexOf("=") + 2,txt.indexOf("=") + 4);//获取Q19第567行文本的参数
		System.out.println(" , the Parameter  is : " + paraStr5);
		outputfile.write(fileID+", 19 , 545-567 ,"+paraStr + "," +paraStr1 + "," +paraStr2 + ","+paraStr3 + "," +paraStr4 + "," +paraStr5);//写入列为文本号，查询号，行号，参数
		outputfile.write("\r\n");
		
		while(RowID != 594){//获取Q20第594行文本
			RowID ++;
			txt = bReader.readLine();
		}
		System.out.print("QueryID is 20 and Line ID : " + RowID +" , the string is : "+txt);
		paraStr = txt.substring(txt.indexOf("'") + 1,txt.length()-2);//获取Q20第594行文本的参数
		System.out.println(" , the Parameter  is : " + paraStr);
		
		while(RowID != 604){//获取Q20第604行文本
			RowID ++;
			txt = bReader.readLine();
		}
		System.out.print("QueryID is 20 and Line ID : " + RowID +" , the string is : "+txt);
		paraStr1 = txt.substring(txt.indexOf("'") + 1,txt.length()-1);//获取Q20第604行文本的参数
		System.out.println(" , the Parameter  is : " + paraStr1);
		
		while(RowID != 609){//获取Q20第609行文本
			RowID ++;
			txt = bReader.readLine();
		}
		System.out.print("QueryID is 20 and Line ID : " + RowID +" , the string is : "+txt);
		paraStr2 = txt.substring(txt.indexOf("'") + 1,txt.length()-1);//获取Q20第609行文本的参数
		System.out.println(" , the Parameter  is : " + paraStr2);
		outputfile.write(fileID+", 20 , 594-609 ,"+paraStr + "," +paraStr1 + "," +paraStr2 );//写入列为文本号，查询号，行号，参数
		outputfile.write("\r\n");
		
		while(RowID != 648){//获取Q21第648行文本
			RowID ++;
			txt = bReader.readLine();
		}
		System.out.print("QueryID is 21 and Line ID : " + RowID +" , the string is : "+txt);
		paraStr = txt.substring(txt.indexOf("'") + 1,txt.length()-1);//获取Q21第648行文本的参数
		System.out.println(" , the Parameter  is : " + paraStr);
		outputfile.write(fileID+", 21 , 648 ,"+paraStr);//写入列为文本号，查询号，行号，参数
		outputfile.write("\r\n");
		
		while(RowID != 670){//获取Q22第670行文本
			RowID ++;
			txt = bReader.readLine();
		}
		System.out.print("QueryID is 22 and Line ID : " + RowID +" , the string is : "+txt);
		paraStr = txt.substring(txt.indexOf("'") + 1,txt.length()-2);//获取Q22第670行文本的参数
		System.out.println(" , the Parameter  is : " + paraStr);
		outputfile.write(fileID+", 22 , 670 ,"+paraStr);//写入列为文本号，查询号，行号，参数
		outputfile.write("\r\n");
	}
	public static void main(String[] args) throws Exception{
		String filepath = "E:\\Documents\\Desktop\\QueryProbe\\QueryText\\";
		String paraTxtPath = "E:\\Documents\\Desktop\\QueryProbe\\";
		ParameterExtractor paraExtractor = new ParameterExtractor(paraTxtPath + "paraTXT.txt");
		paraExtractor.getPara(filepath);
		paraExtractor.CloseFile();
		//paraExtractor.extractor();
	}
}
