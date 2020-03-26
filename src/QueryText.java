
public class QueryText {
	
	double Fraction;//TPC-H SF
	String dbid;
	String userid;
	int paraLength[] = {30,30,30,30,30,30,25,30,30,24,25,30,16,30,30,0,30,4,30,30,25,30};//此处查询编号为TPCH编号				
	public QueryText(double sf,String dbid,String userid) {//SF因子，数据库id，userid
		// TODO Auto-generated constructor stub
		Fraction = sf;
		this.dbid = dbid;
		this.userid = userid;
	}
	/*int paraQ01[]={60,62,64,66,68,70,72,74,76,78,80,82,84,86,88,90,92,94,96,98,100,102,104,106,108,110,112,114,116,118};//length = 30
	String paraQ02[][] = {{"1","BRASS","EUROPE"},{"3","TIN","AFRICA"},{"5","STEEL","EUROPE"},{"7","STEEL","AMERICA"},
			{"10","NICKEL","ASIA"},{"11","COPPER","MIDDLE EAST"},{"13","TIN","AMERICA"},{"15","COPPER","EUROPE"},
			{"17","COPPER","MIDDLE EAST"},{"19","COPPER","AFRICA"},{"21","BRASS","EUROPE"},{"23","TIN","AFRICA"},
			{"25","STEEL","EUROPE"},{"27","STEEL","AMERICA"},{"29","NICKEL","ASIA"},{"31","COPPER","MIDDLE EAST"},
			{"33","BRASS","AMERICA"},{"35","TIN","EUROPE"},{"37","STEEL","MIDDLE EAST"},{"39","STEEL","AFRICA"},
			{"41","NICKEL","EUROPE"},{"43","COPPER","AFRICA"},{"45","TIN","EUROPE"},{"47","COPPER","AMERICA"},
			{"49","NICKEL","ASIA"},{"50","COPPER","MIDDLE EAST"},{"32","TIN","AMERICA"},{"16","COPPER","EUROPE"},
			{"20","COPPER","MIDDLE EAST"},{"12","COPPER","AFRICA"}};//length = 30
	String paraQ03[][]={
			{"AUTOMOBILE","1995-3-1"},{"AUTOMOBILE","1995-3-2"},{"BUILDING","1995-3-3"},{"BUILDING","1995-3-4"},
			{"FURNITURE","1995-3-5"},{"HOUSEHOLD","1995-3-6"},{"HOUSEHOLD","1995-3-7"},{"FURNITURE","1995-3-8"},
			{"MACHINERY","1995-3-9"},{"MACHINERY","1995-3-10"},{"AUTOMOBILE","1995-3-11"},{"AUTOMOBILE","1995-3-12"},
			{"BUILDING","1995-3-13"},{"BUILDING","1995-3-14"},{"FURNITURE","1995-3-15"},{"HOUSEHOLD","1995-3-16"},{"HOUSEHOLD","1995-3-17"},
			{"FURNITURE","1995-3-18"},{"MACHINERY","1995-3-19"},{"MACHINERY","1995-3-20"},{"AUTOMOBILE","1995-3-21"},
			{"AUTOMOBILE","1995-3-22"},{"BUILDING","1995-3-23"},{"BUILDING","1995-3-24"},{"FURNITURE","1995-3-25"},
			{"HOUSEHOLD","1995-3-26"},{"HOUSEHOLD","1995-3-27"},{"FURNITURE","1995-3-28"},{"MACHINERY","1995-3-29"},
			{"MACHINERY","1995-3-30"}};//length = 30
	String paraQ04[]={
			"1993-1-1", "1993-3-1", "1993-5-1", "1993-7-1", "1993-9-1", "1993-11-1", "1994-1-1", "1994-3-1", "1994-5-1", "1994-7-1", "1994-9-1", 
			"1994-11-1", "1995-1-1", "1995-3-1", "1995-5-1", "1995-7-1", "1995-9-1", "1995-11-1", "1996-1-1", "1996-3-1", "1996-5-1", "1996-7-1", 
			"1996-9-1", "1996-11-1", "1997-1-1", "1997-3-1", "1997-5-1", "1997-7-1", "1997-9-1", "1997-6-1", };//length = 30
	String paraQ05[][] = {{"AFRICA","1993-1-1"}, {"AMERICA","1994-1-1"}, {"ASIA","1995-1-1"}, {"EUROPE","1996-1-1"}, {"MIDDLE EAST","1997-1-1"},
			{"AFRICA","1993-1-1"}, {"AMERICA","1994-1-1"}, {"ASIA","1995-1-1"}, {"EUROPE","1996-1-1"}, {"MIDDLE EAST","1997-1-1"}, {"AFRICA","1993-1-1"},
			{"AMERICA","1994-1-1"}, {"ASIA","1995-1-1"}, {"EUROPE","1996-1-1"}, {"MIDDLE EAST","1997-1-1"}, {"AFRICA","1993-1-1"}, {"AMERICA","1994-1-1"}, 
			{"ASIA","1995-1-1"}, {"EUROPE","1996-1-1"}, {"MIDDLE EAST","1997-1-1"}, {"AFRICA","1993-1-1"}, {"AMERICA","1994-1-1"}, {"ASIA","1995-1-1"}, 
			{"EUROPE","1996-1-1"}, {"MIDDLE EAST","1997-1-1"}, {"AFRICA","1993-1-1"}, {"AMERICA","1994-1-1"}, {"ASIA","1995-1-1"}, {"EUROPE","1996-1-1"}, 
			{"MIDDLE EAST","1997-1-1"}};//length = 30
	String paraQ06[][] = {{"1993-1-1","0.02","24"}, {"1993-1-1","0.04","24"}, {"1993-1-1","0.05","25"}, {"1993-1-1","0.06","24"}, {"1993-1-1","0.07","25"}, 
			{"1993-1-1","0.09","25"}, {"1994-1-1","0.02","24"}, {"1994-1-1","0.03","25"}, {"1994-1-1","0.05","25"}, {"1994-1-1","0.06","24"}, {"1994-1-1","0.07","25"}, 
			{"1994-1-1","0.08","24"}, {"1995-1-1","0.03","25"}, {"1995-1-1","0.04","24"}, {"1995-1-1","0.06","24"}, {"1995-1-1","0.07","25"}, {"1995-1-1","0.08","24"}, 
			{"1995-1-1","0.09","25"}, {"1996-1-1","0.02","24"}, {"1996-1-1","0.04","24"}, {"1996-1-1","0.05","25"}, {"1996-1-1","0.07","25"}, {"1996-1-1","0.08","24"}, 
			{"1996-1-1","0.09","25"}, {"1997-1-1","0.03","25"}, {"1997-1-1","0.04","24"}, {"1997-1-1","0.05","25"}, {"1997-1-1","0.06","24"}, {"1997-1-1","0.06","25"}, 
			{"1997-1-1","0.08","24"}};//length = 30
	String paraQ07[][] = {{"ALGERIA","VIETNAM"}, {"ARGENTINA","UNITED STATES"}, {"BRAZIL","UNITED KINGDOM"}, {"CANADA","SAUDI ARABIA"}, {"CHINA","RUSSIA"},
			{"EGYPT","ROMANIA"}, {"ETHIOPIA","PERU"}, {"FRANCE","MOZAMBIQUE"}, {"GERMANY","MOROCCO"}, {"INDIA","KENYA"}, {"INDONESIA","JORDAN"}, 
			{"IRAN","JAPAN"}, {"IRAQ","EGYPT"}, {"JAPAN","IRAN"}, {"JORDAN","INDONESIA"}, {"KENYA","INDIA"}, {"MOROCCO","GERMANY"}, {"MOZAMBIQUE","FRANCE"},
			{"PERU","ETHIOPIA"}, {"ROMANIA","EGYPT"}, {"RUSSIA","CHINA"}, {"SAUDI ARABIA","CANADA"}, {"UNITED KINGDOM","BRAZIL"}, {"UNITED STATES","ARGENTINA"}, 
			{"VIETNAM","ALGERIA"},};//length = 25
	String paraQ08[][] = {{"ALGERIA","AFRICA","PROMO BRUSHED BRASS"}, {"ALGERIA","AFRICA","SMALL BRUSHED COPPER"}, {"ARGENTINA","AMERICA","SMALL BRUSHED COPPER"},
			{"ARGENTINA","AMERICA","STANDARD BRUSHED BRASS"}, {"CANADA","AMERICA","PROMO ANODIZED BRASS"}, {"CANADA","AMERICA","PROMO BRUSHED BRASS"}, 
			{"CHINA","ASIA","PROMO ANODIZED BRASS"}, {"CHINA","ASIA","SMALL BRUSHED COPPER"}, {"CHINA","ASIA","STANDARD BRUSHED BRASS"}, 
			{"EGYPT","AFRICA","STANDARD BRUSHED BRASS"}, {"ETHIOPIA","AFRICA","PROMO ANODIZED BRASS"}, {"ETHIOPIA","AFRICA","STANDARD BRUSHED BRASS"}, 
			{"FRANCE","EUROPE","MEDIUM PLATED NICKEL"}, {"FRANCE","EUROPE","STANDARD BRUSHED BRASS"}, {"INDIA","ASIA","PROMO ANODIZED BRASS"},
			{"INDIA","ASIA","STANDARD BURNISHED BRASS"}, {"INDONESIA","ASIA","PROMO ANODIZED BRASS"}, {"INDONESIA","ASIA","PROMO BRUSHED BRASS"}, 
			{"IRAN","MIDDLE EAST","MEDIUM PLATED NICKEL"}, {"IRAN","MIDDLE EAST","PROMO ANODIZED BRASS"}, {"IRAN","MIDDLE EAST","STANDARD ANODIZED TIN"}, 
			{"JORDAN","MIDDLE EAST","ECONOMY ANODIZED NICKEL"}, {"JORDAN","MIDDLE EAST","MEDIUM PLATED NICKEL"}, {"MOZAMBIQUE","AFRICA","STANDARD BURNISHED BRASS"},
			{"PERU","AMERICA","PROMO PLATED BRASS"}, {"ROMANIA","EUROPE","PROMO ANODIZED BRASS"}, {"ROMANIA","EUROPE","STANDARD ANODIZED TIN"}, 
			{"RUSSIA","EUROPE","MEDIUM PLATED NICKEL"}, {"RUSSIA","EUROPE","PROMO BRUSHED BRASS"}, {"SAUDI ARABIA","MIDDLE EAST","ECONOMY ANODIZED NICKEL"}};//length = 30
	String paraQ09[]={"almond", "antique", "aquamarine", "beige", "black", "burnished", "chartreuse", "chiffon", "coral", "cornsilk", "gainsboro", "ghost", "green", 
			"honeydew", "indian", "ivory", "lavender", "light", "magenta", "metallic", "moccasin", "pale", "papaya", "seashell", "sky", "tan", "thistle", "violet", "white",
			"yellow"};//length = 30
	String paraQ10[]={"1993-2-1", "1993-3-1", "1993-4-1", "1993-5-1", "1993-6-1", "1993-7-1", "1993-8-1", "1993-9-1", "1993-10-1", "1993-11-1", "1993-12-1", 
			"1994-1-1", "1994-2-1","1994-3-1", "1994-4-1", "1994-5-1", "1994-6-1", "1994-7-1", "1994-8-1", "1994-9-1", "1994-10-1", "1994-11-1", "1994-12-1",
			"1995-1-1"};//length = 24
	String paraQ11[]={"ALGERIA", "ARGENTINA", "BRAZIL", "CANADA", "CHINA", "EGYPT", "ETHIOPIA", "FRANCE", "GERMANY", "INDIA", "INDONESIA", "IRAN", "IRAQ", 
			"JAPAN", "JORDAN", "KENYA", "MOROCCO", "MOZAMBIQUE", "PERU", "ROMANIA", "RUSSIA", "SAUDI ARABIA", "UNITED KINGDOM", 
			"UNITED STATES", "VIETNAM", };//length = 25
	String paraQ12[][]={{"AIR', 'TRUCK","1993-1-1"}, {"FOB', 'SHIP","1993-3-1"}, {"MAIL', 'REGAIR","1993-5-1"}, {"RAIL', 'REGAIR","1993-7-1"}, {"REGAIR', 'MAIL","1993-9-1"}, 
			{"SHIP', 'FOB","1993-11-1"}, {"TRUCK', 'AIR","1994-1-1"}, {"AIR', 'TRUCK","1994-3-1"}, {"FOB', 'SHIP","1994-5-1"}, {"MAIL', 'REGAIR","1994-7-1"}, 
			{"RAIL', 'TRUCK","1994-9-1"}, {"REGAIR', 'MAIL","1994-11-1"}, {"SHIP', 'FOB","1995-1-1"}, {"TRUCK', 'AIR","1995-3-1"}, {"AIR', 'TRUCK","1995-5-1"}, 
			{"FOB', 'SHIP","1995-7-1"}, {"MAIL', 'REGAIR","1995-9-1"}, {"RAIL', 'FOB","1995-11-1"}, {"REGAIR', 'MAIL","1996-1-1"}, {"SHIP', 'FOB","1996-3-1"}, 
			{"TRUCK', 'AIR","1996-5-1"}, {"AIR', 'TRUCK","1996-7-1"}, {"FOB', 'SHIP","1996-9-1"}, {"MAIL', 'REGAIR","1996-11-1"}, {"RAIL', 'AIR","1997-1-1"}, 
			{"REGAIR', 'MAIL","1993-2-1"}, {"SHIP', 'FOB","1994-4-1"}, {"TRUCK', 'AIR","1995-6-1"}, {"AIR', 'TRUCK","1996-8-1"}, {"FOB', 'SHIP","1994-8-1"}};//length = 30
	String paraQ13[] = {"%special%packages%", "%special%requests%", "%special%accounts%", "%special%deposits%", "%pending%packages%", 
			"%pending%requests%", "%pending%accounts%", "%pending%deposits%", "%unusual%packages%", "%unusual%requests%", "%unusual%accounts%", 
			"%unusual%deposits%", "%express%packages%", "%express%requests%", "%express%accounts%" ,"%express%deposits%"};//length = 16
	String paraQ14[]={"1993-2-1", "1993-4-1", "1993-6-1", "1993-8-1", "1993-10-1", "1993-12-1", "1994-2-1", "1994-4-1", "1994-6-1", "1994-8-1", "1994-10-1",
			"1994-12-1", "1995-2-1", "1995-4-1", "1995-6-1", "1995-8-1", "1995-10-1", "1995-12-1", "1996-2-1", "1996-4-1", "1996-6-1", "1996-8-1", "1996-10-1", 
			"1996-12-1", "1993-1-1", "1994-1-1", "1995-1-1", "1996-1-1", "1997-1-1", "1994-9-1"};//length = 30
	String paraQ16[][] = {{"Brand#12","PROMO BURNISHED","15,22,43,47,36,21,12,16"},{"Brand#14","PROMO BURNISHED","15,22,43,47,36,21,12,16"},
			{"Brand#15","PROMO BURNISHED","9,24,33,10,44,11,6,21"},{"Brand#21","MEDIUM PLATED","49,48,16,29,10,46,33,36"},
			{"Brand#23","MEDIUM PLATED","32,7,9,24,4,22,45,33"},{"Brand#24","MEDIUM PLATED","15,22,43,47,36,21,12,16"},
			{"Brand#22","SMALL PLATED","5,35,21,42,41,14,22,37"},{"Brand#25","SMALL PLATED","9,24,33,10,44,11,6,21"},
			{"Brand#21","SMALL PLATED","49,48,16,29,10,46,33,36"},{"Brand#21","MEDIUM ANODIZED","9,24,33,10,44,11,6,21"},
			{"Brand#23","MEDIUM ANODIZED","32,7,9,24,4,22,45,33"},{"Brand#24","MEDIUM ANODIZED","46,40,45,41,11,39,50,49"},
			{"Brand#31","MEDIUM BRUSHED","12,50,10,19,39,28,33,1"},{"Brand#32","MEDIUM BRUSHED","49,48,16,29,10,46,33,36"},
			{"Brand#34","MEDIUM BRUSHED","15,22,43,47,36,21,12,16"},{"Brand#32","MEDIUM ANODIZED","15,3,36,26,40,11,17,13"},
			{"Brand#33","MEDIUM ANODIZED","9,24,33,10,44,11,6,21"},{"Brand#34","MEDIUM ANODIZED","46,40,45,41,11,39,50,49"},
			{"Brand#41","STANDARD POLISHED","8,30,25,39,42,35,10,1"},{"Brand#42","STANDARD POLISHED","32,7,9,24,4,22,45,33"},
			{"Brand#43","STANDARD POLISHED","18,42,28,3,32,14,35,20"},{"Brand#42","ECONOMY BRUSHED","46,40,45,41,11,39,50,49"},
			{"Brand#44","ECONOMY BRUSHED","32,7,9,24,4,22,45,33"},{"Brand#45","ECONOMY BRUSHED","32,7,9,24,4,22,45,33"},
			{"Brand#51","SMALL PLATED","18,42,28,3,32,14,35,20"},{"Brand#52","SMALL PLATED","32,7,9,24,4,22,45,33"},
			{"Brand#53","SMALL PLATED","18,42,28,3,32,14,35,20"},{"Brand#52","ECONOMY BRUSHED","32,7,9,24,4,22,45,33"},
			{"Brand#53","ECONOMY BRUSHED","32,7,9,24,4,22,45,33"},{"Brand#54","ECONOMY BRUSHED","46,40,45,41,11,39,50,49"}};//length = 30
	String paraQ17[][] = {{"Brand#12","SM CAN"},{"Brand#14","LG CAN"},{"Brand#15","LG CASE"},{"Brand#21","LG JAR"},{"Brand#21","SM CAN"},
			{"Brand#21","WRAP PACK"},{"Brand#22","JUMBO BOX"},{"Brand#23","SM JAR"},{"Brand#23","WRAP CAN"},{"Brand#24","WRAP CAN"},
			{"Brand#24","LG JAR"},{"Brand#25","LG JAR"},{"Brand#31","SM CAN"},{"Brand#32","LG CAN"},{"Brand#32","LG CASE"},{"Brand#33","LG JAR"},
			{"Brand#34","SM CAN"},{"Brand#34","WRAP PACK"},{"Brand#41","JUMBO BOX"},{"Brand#42","SM JAR"},{"Brand#42","WRAP CAN"},
			{"Brand#43","WRAP CAN"},{"Brand#44","LG JAR"},{"Brand#45","LG JAR"},{"Brand#51","WRAP PACK"},{"Brand#52","JUMBO BOX"},
			{"Brand#52","SM JAR"},{"Brand#53","WRAP CAN"},{"Brand#53","SM CAN"},{"Brand#54","LG JAR"}};//length = 30
	String paraQ18[]={"312","313","314","315"};//length = 4
	String paraQ19[][]={{"Brand#54","1","Brand#12","20","Brand#54","10"},{"Brand#53","1","Brand#14","27","Brand#53","15"},
			{"Brand#53","1","Brand#15","30","Brand#53","20"},{"Brand#52","2","Brand#21","21","Brand#52","11"},
			{"Brand#52","2","Brand#21","28","Brand#52","16"},{"Brand#51","2","Brand#21","29","Brand#51","19"},
			{"Brand#45","3","Brand#22","22","Brand#24","12"},{"Brand#44","3","Brand#23","29","Brand#24","17"},
			{"Brand#43","3","Brand#23","28","Brand#25","18"},{"Brand#42","4","Brand#24","23","Brand#31","13"},
			{"Brand#42","4","Brand#24","27","Brand#32","17"},{"Brand#41","4","Brand#25","30","Brand#32","18"},
			{"Brand#34","5","Brand#31","24","Brand#34","14"},{"Brand#34","5","Brand#32","26","Brand#32","16"},
			{"Brand#33","5","Brand#32","29","Brand#32","19"},{"Brand#32","6","Brand#33","25","Brand#53","15"},
			{"Brand#32","6","Brand#34","25","Brand#53","18"},{"Brand#31","6","Brand#34","28","Brand#52","20"},
			{"Brand#25","7","Brand#41","24","Brand#52","14"},{"Brand#24","7","Brand#42","26","Brand#42","16"},
			{"Brand#24","7","Brand#42","27","Brand#42","19"},{"Brand#23","8","Brand#43","23","Brand#25","13"},
			{"Brand#23","8","Brand#44","27","Brand#24","17"},{"Brand#22","8","Brand#45","26","Brand#24","18"},
			{"Brand#21","9","Brand#51","22","Brand#23","12"},{"Brand#21","9","Brand#52","25","Brand#23","17"},
			{"Brand#21","9","Brand#52","28","Brand#22","18"},{"Brand#15","10","Brand#53","21","Brand#21","11"},
			{"Brand#14","10","Brand#53","24","Brand#53","19"},{"Brand#12","10","Brand#54","29","Brand#54","19"}};//length = 30
	String paraQ20[][] = {{"almond","1993-1-1","JAPAN"},{"antique","1993-2-1","IRAN"},{"aquamarine","1993-3-1","UNITED KINGDOM"},
			{"beige","1993-4-1","CANADA"},{"black","1993-5-1","CHINA"},{"burnished","1993-6-1","SAUDI ARABIA"},
			{"chartreuse","1993-7-1","ROMANIA"},{"chiffon","1993-8-1","JAPAN"},{"coral","1993-9-1","JORDAN"},
			{"cornsilk","1993-10-1","INDIA"},{"gainsboro","1993-11-1","JAPAN"},{"ghost","1993-12-1","IRAN"},
			{"green","1994-1-1","UNITED KINGDOM"},{"honeydew","1994-2-1","CANADA"},{"indian","1994-3-1","CHINA"},
			{"ivory","1994-4-1","SAUDI ARABIA"},{"lavender","1994-5-1","ROMANIA"},{"light","1994-6-1","JAPAN"},
			{"magenta","1994-7-1","JORDAN"},{"metallic","1994-8-1","INDIA"},{"moccasin","1994-9-1","JAPAN"},
			{"pale","1994-10-1","IRAN"},{"papaya","1994-11-1","UNITED KINGDOM"},{"seashell","1994-12-1","CANADA"},
			{"sky","1995-1-1","CHINA"},{"tan","1995-2-1","SAUDI ARABIA"},{"thistle","1995-3-1","ROMANIA"},{"violet","1995-4-1","JAPAN"},
			{"white","1995-5-1","JORDAN"},{"yellow","1995-6-1","INDIA"}};//length = 30
	String paraQ21[]={"ALGERIA","ARGENTINA","BRAZIL","CANADA","CHINA","EGYPT","ETHIOPIA","FRANCE",
			"GERMANY","INDIA","INDONESIA","IRAN","IRAQ","JAPAN","JORDAN","KENYA","MOROCCO","MOZAMBIQUE",
			"PERU","ROMANIA","RUSSIA","SAUDI ARABIA","UNITED KINGDOM","UNITED STATES","VIETNAM",};//length = 25
	
	String paraQ22[] = {"'22','10','19','23','12','25','34'","'21','12','20','23','13','24','33'","'21','13','20','23','14','25','32'",
			"'22','14','19','26','15','27','31'","'21','15','18','23','16','27','30'","'20','13','17','24','16','28','29'",
			"'19','16','18','25','17','28','29'","'19','12','18','26','15','27','30'","'20','14','19','26','17','27','31'",
			"'21','13','20','25','16','28','32'","'24','12','21','26','17','29','33'","'23','10','22','25','18','30','34'",
			"'21','14','22','23','19','26','31'","'23','15','21','24','20','27','30'","'24','17','21','26','19','28','32'",
			"'21','16','27','25','20','28','29'","'24','33','26','19','22','29','20'","'28','26','19','17','29','22','19'",
			"'25','34','18','21','27','30','19'","'20','14','18','22','17','26','28'","'23','18','16','27','14','22','30'",
			"'19','15','17','21','16','27','29'","'24','17','19','26','13','28','31'","'18','15','13','20','16','28','30'",
			"'20','16','27','21','12','25','29'","'20','15','21','24','17','26','30'","'25','14','22','23','18','27','31'",
			"'23','13','22','26','19','28','32'","'24','12','21','27','20','29','33'","'25','10','21','25','20','30','34'"};//length = 30
*/	//String paraQ23[] = {"100","500","1000","2000","5000","10000","50000","100000","500000"};//length = 9
	String paraQ01[][] = {{"1","BRASS","EUROPE"},{"3","TIN","AFRICA"},{"5","STEEL","EUROPE"},{"7","STEEL","AMERICA"},
			{"10","NICKEL","ASIA"},{"11","COPPER","MIDDLE EAST"},{"13","TIN","AMERICA"},{"15","COPPER","EUROPE"},
			{"17","COPPER","MIDDLE EAST"},{"19","COPPER","AFRICA"},{"21","BRASS","EUROPE"},{"23","TIN","AFRICA"},
			{"25","STEEL","EUROPE"},{"27","STEEL","AMERICA"},{"29","NICKEL","ASIA"},{"31","COPPER","MIDDLE EAST"},
			{"33","BRASS","AMERICA"},{"35","TIN","EUROPE"},{"37","STEEL","MIDDLE EAST"},{"39","STEEL","AFRICA"},
			{"41","NICKEL","EUROPE"},{"43","COPPER","AFRICA"},{"45","TIN","EUROPE"},{"47","COPPER","AMERICA"},
			{"49","NICKEL","ASIA"},{"50","COPPER","MIDDLE EAST"},{"32","TIN","AMERICA"},{"16","COPPER","EUROPE"},
			{"20","COPPER","MIDDLE EAST"},{"12","COPPER","AFRICA"}};//length = 30
	String paraQ02[][] = {{"1","BRASS","EUROPE"},{"3","TIN","AFRICA"},{"5","STEEL","EUROPE"},{"7","STEEL","AMERICA"},
			{"10","NICKEL","ASIA"},{"11","COPPER","MIDDLE EAST"},{"13","TIN","AMERICA"},{"15","COPPER","EUROPE"},
			{"17","COPPER","MIDDLE EAST"},{"19","COPPER","AFRICA"},{"21","BRASS","EUROPE"},{"23","TIN","AFRICA"},
			{"25","STEEL","EUROPE"},{"27","STEEL","AMERICA"},{"29","NICKEL","ASIA"},{"31","COPPER","MIDDLE EAST"},
			{"33","BRASS","AMERICA"},{"35","TIN","EUROPE"},{"37","STEEL","MIDDLE EAST"},{"39","STEEL","AFRICA"},
			{"41","NICKEL","EUROPE"},{"43","COPPER","AFRICA"},{"45","TIN","EUROPE"},{"47","COPPER","AMERICA"},
			{"49","NICKEL","ASIA"},{"50","COPPER","MIDDLE EAST"},{"32","TIN","AMERICA"},{"16","COPPER","EUROPE"},
			{"20","COPPER","MIDDLE EAST"},{"12","COPPER","AFRICA"}};//length = 30
	String paraQ03[][] = {{"1","BRASS","EUROPE"},{"3","TIN","AFRICA"},{"5","STEEL","EUROPE"},{"7","STEEL","AMERICA"},
			{"10","NICKEL","ASIA"},{"11","COPPER","MIDDLE EAST"},{"13","TIN","AMERICA"},{"15","COPPER","EUROPE"},
			{"17","COPPER","MIDDLE EAST"},{"19","COPPER","AFRICA"},{"21","BRASS","EUROPE"},{"23","TIN","AFRICA"},
			{"25","STEEL","EUROPE"},{"27","STEEL","AMERICA"},{"29","NICKEL","ASIA"},{"31","COPPER","MIDDLE EAST"},
			{"33","BRASS","AMERICA"},{"35","TIN","EUROPE"},{"37","STEEL","MIDDLE EAST"},{"39","STEEL","AFRICA"},
			{"41","NICKEL","EUROPE"},{"43","COPPER","AFRICA"},{"45","TIN","EUROPE"},{"47","COPPER","AMERICA"},
			{"49","NICKEL","ASIA"},{"50","COPPER","MIDDLE EAST"},{"32","TIN","AMERICA"},{"16","COPPER","EUROPE"},
			{"20","COPPER","MIDDLE EAST"},{"12","COPPER","AFRICA"}};//length = 30
	String paraQ04[][]={
			{"AUTOMOBILE","1995-3-1"},{"AUTOMOBILE","1995-3-2"},{"BUILDING","1995-3-3"},{"BUILDING","1995-3-4"},
			{"FURNITURE","1995-3-5"},{"HOUSEHOLD","1995-3-6"},{"HOUSEHOLD","1995-3-7"},{"FURNITURE","1995-3-8"},
			{"MACHINERY","1995-3-9"},{"MACHINERY","1995-3-10"},{"AUTOMOBILE","1995-3-11"},{"AUTOMOBILE","1995-3-12"},
			{"BUILDING","1995-3-13"},{"BUILDING","1995-3-14"},{"FURNITURE","1995-3-15"},{"HOUSEHOLD","1995-3-16"},{"HOUSEHOLD","1995-3-17"},
			{"FURNITURE","1995-3-18"},{"MACHINERY","1995-3-19"},{"MACHINERY","1995-3-20"},{"AUTOMOBILE","1995-3-21"},
			{"AUTOMOBILE","1995-3-22"},{"BUILDING","1995-3-23"},{"BUILDING","1995-3-24"},{"FURNITURE","1995-3-25"},
			{"HOUSEHOLD","1995-3-26"},{"HOUSEHOLD","1995-3-27"},{"FURNITURE","1995-3-28"},{"MACHINERY","1995-3-29"},
			{"MACHINERY","1995-3-30"}};//length = 30
	String paraQ05[][]={
			{"AUTOMOBILE","1995-3-1"},{"AUTOMOBILE","1995-3-2"},{"BUILDING","1995-3-3"},{"BUILDING","1995-3-4"},
			{"FURNITURE","1995-3-5"},{"HOUSEHOLD","1995-3-6"},{"HOUSEHOLD","1995-3-7"},{"FURNITURE","1995-3-8"},
			{"MACHINERY","1995-3-9"},{"MACHINERY","1995-3-10"},{"AUTOMOBILE","1995-3-11"},{"AUTOMOBILE","1995-3-12"},
			{"BUILDING","1995-3-13"},{"BUILDING","1995-3-14"},{"FURNITURE","1995-3-15"},{"HOUSEHOLD","1995-3-16"},{"HOUSEHOLD","1995-3-17"},
			{"FURNITURE","1995-3-18"},{"MACHINERY","1995-3-19"},{"MACHINERY","1995-3-20"},{"AUTOMOBILE","1995-3-21"},
			{"AUTOMOBILE","1995-3-22"},{"BUILDING","1995-3-23"},{"BUILDING","1995-3-24"},{"FURNITURE","1995-3-25"},
			{"HOUSEHOLD","1995-3-26"},{"HOUSEHOLD","1995-3-27"},{"FURNITURE","1995-3-28"},{"MACHINERY","1995-3-29"},
			{"MACHINERY","1995-3-30"}};//length = 30
	String paraQ06[][]={
			{"AUTOMOBILE","1995-3-1"},{"AUTOMOBILE","1995-3-2"},{"BUILDING","1995-3-3"},{"BUILDING","1995-3-4"},
			{"FURNITURE","1995-3-5"},{"HOUSEHOLD","1995-3-6"},{"HOUSEHOLD","1995-3-7"},{"FURNITURE","1995-3-8"},
			{"MACHINERY","1995-3-9"},{"MACHINERY","1995-3-10"},{"AUTOMOBILE","1995-3-11"},{"AUTOMOBILE","1995-3-12"},
			{"BUILDING","1995-3-13"},{"BUILDING","1995-3-14"},{"FURNITURE","1995-3-15"},{"HOUSEHOLD","1995-3-16"},{"HOUSEHOLD","1995-3-17"},
			{"FURNITURE","1995-3-18"},{"MACHINERY","1995-3-19"},{"MACHINERY","1995-3-20"},{"AUTOMOBILE","1995-3-21"},
			{"AUTOMOBILE","1995-3-22"},{"BUILDING","1995-3-23"},{"BUILDING","1995-3-24"},{"FURNITURE","1995-3-25"},
			{"HOUSEHOLD","1995-3-26"},{"HOUSEHOLD","1995-3-27"},{"FURNITURE","1995-3-28"},{"MACHINERY","1995-3-29"},
			{"MACHINERY","1995-3-30"}};//length = 30
	String paraQ07[]={
			"1993-1-1", "1993-3-1", "1993-5-1", "1993-7-1", "1993-9-1", "1993-11-1", "1994-1-1", "1994-3-1", "1994-5-1", "1994-7-1", "1994-9-1", 
			"1994-11-1", "1995-1-1", "1995-3-1", "1995-5-1", "1995-7-1", "1995-9-1", "1995-11-1", "1996-1-1", "1996-3-1", "1996-5-1", "1996-7-1", 
			"1996-9-1", "1996-11-1", "1997-1-1", "1997-3-1", "1997-5-1", "1997-7-1", "1997-9-1", "1997-6-1", };//length = 30
	String paraQ08[]={
			"1993-1-1", "1993-3-1", "1993-5-1", "1993-7-1", "1993-9-1", "1993-11-1", "1994-1-1", "1994-3-1", "1994-5-1", "1994-7-1", "1994-9-1", 
			"1994-11-1", "1995-1-1", "1995-3-1", "1995-5-1", "1995-7-1", "1995-9-1", "1995-11-1", "1996-1-1", "1996-3-1", "1996-5-1", "1996-7-1", 
			"1996-9-1", "1996-11-1", "1997-1-1", "1997-3-1", "1997-5-1", "1997-7-1", "1997-9-1", "1997-6-1", };//length = 30
	String paraQ09[]={
			"1993-1-1", "1993-3-1", "1993-5-1", "1993-7-1", "1993-9-1", "1993-11-1", "1994-1-1", "1994-3-1", "1994-5-1", "1994-7-1", "1994-9-1", 
			"1994-11-1", "1995-1-1", "1995-3-1", "1995-5-1", "1995-7-1", "1995-9-1", "1995-11-1", "1996-1-1", "1996-3-1", "1996-5-1", "1996-7-1", 
			"1996-9-1", "1996-11-1", "1997-1-1", "1997-3-1", "1997-5-1", "1997-7-1", "1997-9-1", "1997-6-1", };//length = 30
	String paraQ10[]={"1993-2-1", "1993-3-1", "1993-4-1", "1993-5-1", "1993-6-1", "1993-7-1", "1993-8-1", "1993-9-1", "1993-10-1", "1993-11-1", "1993-12-1", 
			"1994-1-1", "1994-2-1","1994-3-1", "1994-4-1", "1994-5-1", "1994-6-1", "1994-7-1", "1994-8-1", "1994-9-1", "1994-10-1", "1994-11-1", "1994-12-1",
			"1995-1-1"};//length = 24
	String paraQ11[]={"1993-2-1", "1993-3-1", "1993-4-1", "1993-5-1", "1993-6-1", "1993-7-1", "1993-8-1", "1993-9-1", "1993-10-1", "1993-11-1", "1993-12-1", 
			"1994-1-1", "1994-2-1","1994-3-1", "1994-4-1", "1994-5-1", "1994-6-1", "1994-7-1", "1994-8-1", "1994-9-1", "1994-10-1", "1994-11-1", "1994-12-1",
			"1995-1-1"};//length = 24
	String paraQ12[]={"1993-2-1", "1993-3-1", "1993-4-1", "1993-5-1", "1993-6-1", "1993-7-1", "1993-8-1", "1993-9-1", "1993-10-1", "1993-11-1", "1993-12-1", 
			"1994-1-1", "1994-2-1","1994-3-1", "1994-4-1", "1994-5-1", "1994-6-1", "1994-7-1", "1994-8-1", "1994-9-1", "1994-10-1", "1994-11-1", "1994-12-1",
			"1995-1-1"};//length = 24
	String paraQ13[]={"1993-2-1", "1993-4-1", "1993-6-1", "1993-8-1", "1993-10-1", "1993-12-1", "1994-2-1", "1994-4-1", "1994-6-1", "1994-8-1", "1994-10-1",
			"1994-12-1", "1995-2-1", "1995-4-1", "1995-6-1", "1995-8-1", "1995-10-1", "1995-12-1", "1996-2-1", "1996-4-1", "1996-6-1", "1996-8-1", "1996-10-1", 
			"1996-12-1", "1993-1-1", "1994-1-1", "1995-1-1", "1996-1-1", "1997-1-1", "1994-9-1"};//length = 30
	String paraQ14[]={"1993-2-1", "1993-4-1", "1993-6-1", "1993-8-1", "1993-10-1", "1993-12-1", "1994-2-1", "1994-4-1", "1994-6-1", "1994-8-1", "1994-10-1",
			"1994-12-1", "1995-2-1", "1995-4-1", "1995-6-1", "1995-8-1", "1995-10-1", "1995-12-1", "1996-2-1", "1996-4-1", "1996-6-1", "1996-8-1", "1996-10-1", 
			"1996-12-1", "1993-1-1", "1994-1-1", "1995-1-1", "1996-1-1", "1997-1-1", "1994-9-1"};//length = 30
	String paraQ15[]={"1993-2-1", "1993-4-1", "1993-6-1", "1993-8-1", "1993-10-1", "1993-12-1", "1994-2-1", "1994-4-1", "1994-6-1", "1994-8-1", "1994-10-1",
			"1994-12-1", "1995-2-1", "1995-4-1", "1995-6-1", "1995-8-1", "1995-10-1", "1995-12-1", "1996-2-1", "1996-4-1", "1996-6-1", "1996-8-1", "1996-10-1", 
			"1996-12-1", "1993-1-1", "1994-1-1", "1995-1-1", "1996-1-1", "1997-1-1", "1994-9-1"};//length = 30
	String paraQ16[] = {"'22','10','19','23','12','25','34'","'21','12','20','23','13','24','33'","'21','13','20','23','14','25','32'",
			"'22','14','19','26','15','27','31'","'21','15','18','23','16','27','30'","'20','13','17','24','16','28','29'",
			"'19','16','18','25','17','28','29'","'19','12','18','26','15','27','30'","'20','14','19','26','17','27','31'",
			"'21','13','20','25','16','28','32'","'24','12','21','26','17','29','33'","'23','10','22','25','18','30','34'",
			"'21','14','22','23','19','26','31'","'23','15','21','24','20','27','30'","'24','17','21','26','19','28','32'",
			"'21','16','27','25','20','28','29'","'24','33','26','19','22','29','20'","'28','26','19','17','29','22','19'",
			"'25','34','18','21','27','30','19'","'20','14','18','22','17','26','28'","'23','18','16','27','14','22','30'",
			"'19','15','17','21','16','27','29'","'24','17','19','26','13','28','31'","'18','15','13','20','16','28','30'",
			"'20','16','27','21','12','25','29'","'20','15','21','24','17','26','30'","'25','14','22','23','18','27','31'",
			"'23','13','22','26','19','28','32'","'24','12','21','27','20','29','33'","'25','10','21','25','20','30','34'"};//length = 30
	String paraQ17[] = {"'22','10','19','23','12','25','34'","'21','12','20','23','13','24','33'","'21','13','20','23','14','25','32'",
			"'22','14','19','26','15','27','31'","'21','15','18','23','16','27','30'","'20','13','17','24','16','28','29'",
			"'19','16','18','25','17','28','29'","'19','12','18','26','15','27','30'","'20','14','19','26','17','27','31'",
			"'21','13','20','25','16','28','32'","'24','12','21','26','17','29','33'","'23','10','22','25','18','30','34'",
			"'21','14','22','23','19','26','31'","'23','15','21','24','20','27','30'","'24','17','21','26','19','28','32'",
			"'21','16','27','25','20','28','29'","'24','33','26','19','22','29','20'","'28','26','19','17','29','22','19'",
			"'25','34','18','21','27','30','19'","'20','14','18','22','17','26','28'","'23','18','16','27','14','22','30'",
			"'19','15','17','21','16','27','29'","'24','17','19','26','13','28','31'","'18','15','13','20','16','28','30'",
			"'20','16','27','21','12','25','29'","'20','15','21','24','17','26','30'","'25','14','22','23','18','27','31'",
			"'23','13','22','26','19','28','32'","'24','12','21','27','20','29','33'","'25','10','21','25','20','30','34'"};//length = 30
	String paraQ18[] = {"'22','10','19','23','12','25','34'","'21','12','20','23','13','24','33'","'21','13','20','23','14','25','32'",
			"'22','14','19','26','15','27','31'","'21','15','18','23','16','27','30'","'20','13','17','24','16','28','29'",
			"'19','16','18','25','17','28','29'","'19','12','18','26','15','27','30'","'20','14','19','26','17','27','31'",
			"'21','13','20','25','16','28','32'","'24','12','21','26','17','29','33'","'23','10','22','25','18','30','34'",
			"'21','14','22','23','19','26','31'","'23','15','21','24','20','27','30'","'24','17','21','26','19','28','32'",
			"'21','16','27','25','20','28','29'","'24','33','26','19','22','29','20'","'28','26','19','17','29','22','19'",
			"'25','34','18','21','27','30','19'","'20','14','18','22','17','26','28'","'23','18','16','27','14','22','30'",
			"'19','15','17','21','16','27','29'","'24','17','19','26','13','28','31'","'18','15','13','20','16','28','30'",
			"'20','16','27','21','12','25','29'","'20','15','21','24','17','26','30'","'25','14','22','23','18','27','31'",
			"'23','13','22','26','19','28','32'","'24','12','21','27','20','29','33'","'25','10','21','25','20','30','34'"};//length = 30
	public String getQueryString(int tempID,int paraID) {//tempID, paraID 都是从1开始计数。 查询模板和参数是对应的。
		String sql = null;
		switch (tempID) {
		/*case 1:
			sql = "select l_returnflag,l_linestatus,sum(l_quantity) as sum_qty,sum(l_extendedprice) as sum_base_price,sum("
					+ "l_extendedprice * (1 - l_discount)) as sum_disc_price,sum(l_extendedprice * (1 - l_discount) * (1 + l_tax)) "
					+ "as sum_charge,avg(l_quantity) as avg_qty,avg(l_extendedprice) as avg_price,avg(l_discount) as avg_disc,count(*) "
					+ "as count_order from lineitem where l_shipdate <= date ('1998-12-01') - interval '" +paraQ01[paraID]+
					"'day group by l_returnflag,l_linestatus order by l_returnflag,l_linestatus;";
			break;
		case 2:
			sql = "select s_acctbal,s_name,n_name,p_partkey,p_mfgr,s_address,s_phone,s_comment from part,supplier,partsupp,nation,region"
					+ " where p_partkey = ps_partkey and s_suppkey = ps_suppkey and p_size = "+paraQ02[paraID][0]+" and p_type like '%"+paraQ02[paraID][1]+"' and s_nationkey = n_nationkey "
					+ "and n_regionkey = r_regionkey and r_name = '" +paraQ02[paraID][2] + "' and ps_supplycost = (select min(ps_supplycost) from partsupp,supplier,nation,region "
					+ "where p_partkey = ps_partkey and s_suppkey = ps_suppkey and s_nationkey = n_nationkey and n_regionkey = r_regionkey and r_name ='" +paraQ02[paraID][2]+ "') "
					+ "order by s_acctbal desc,n_name,s_name,p_partkey;";
			break;
		case 3:
			sql = "select l_orderkey,sum(l_extendedprice * (1 - l_discount)) as revenue,o_orderdate,o_shippriority from customer,orders,lineitem where c_mktsegment = '"+paraQ03[paraID][0]+"' "
					+ "and c_custkey = o_custkey and l_orderkey = o_orderkey and o_orderdate < date ('"+paraQ03[paraID][1]+ "') and l_shipdate > date ('"+paraQ03[paraID][1]+"') group by "
					+ "l_orderkey,o_orderdate,o_shippriority order by revenue desc,o_orderdate;";
			break;
		case 4:
			sql = "select o_orderpriority,count(*) as order_count from orders where o_orderdate >= date ('1993-7-1') and o_orderdate < date ('"+paraQ04[paraID] +"') "
					+ "+ interval '3' month and exists ( select * from lineitem where l_orderkey = o_orderkey and l_commitdate < l_receiptdate) group by o_orderpriority "
					+ "order by o_orderpriority;";
			break;
		case 5:
			sql = "select n_name,sum(l_extendedprice * (1 - l_discount)) as revenue from customer,orders,lineitem,supplier,nation,region where c_custkey = o_custkey and"
					+ " l_orderkey = o_orderkey and l_suppkey = s_suppkey and c_nationkey = s_nationkey and s_nationkey = n_nationkey and n_regionkey = r_regionkey and "
					+ "r_name = '"+ paraQ05[paraID][0]+"' and o_orderdate >= date ('"+ paraQ05[paraID][1]+"') and o_orderdate < date ('"+ paraQ05[paraID][1]+"') + interval '1' year group by n_name order by revenue desc;";
			break;
		case 6:
			sql = "select sum(l_extendedprice * l_discount) as revenue from lineitem where l_shipdate >= date ('"+ paraQ06[paraID][0]+"') and l_shipdate < date ('"+ paraQ06[paraID][0]+"') +"
					+ " interval '1' year and l_discount between "+ paraQ06[paraID][1]+" - 0.01 and "+ paraQ06[paraID][1]+" + 0.01 and l_quantity < "+ paraQ06[paraID][2]+";";
			break;
		case 7:
			sql = "select supp_nation,cust_nation,l_year,sum(volume) as revenue from ( select n1.n_name as supp_nation,n2.n_name as cust_nation,extract(year from l_shipdate) "
					+ "as l_year,l_extendedprice * (1 - l_discount) as volume from supplier,lineitem,orders,customer,nation n1,nation n2 where s_suppkey = l_suppkey and o_orderkey"
					+ " = l_orderkey and c_custkey = o_custkey and s_nationkey = n1.n_nationkey and c_nationkey = n2.n_nationkey and ((n1.n_name = '"+ paraQ07[paraID][0]+"' and "
					+ "n2.n_name = '"+ paraQ07[paraID][1]+"') or (n1.n_name = '"+ paraQ07[paraID][1]+"' and n2.n_name = '"+ paraQ07[paraID][0]+"')) and l_shipdate between date ('1995-01-01') and date ('1996-12-31')) "
					+ "as shipping group by supp_nation,cust_nation,l_year order by supp_nation,cust_nation,l_year;";
			break;
		case 8:
			sql = "select o_year,sum(case when nation = '"+paraQ08[paraID][0] +"' then volume else 0 end) / sum(volume) as mkt_share from (select extract(year from o_orderdate)"
					+ " as o_year,l_extendedprice * (1 - l_discount) as volume,n2.n_name as nation from part,supplier,lineitem,orders,customer,nation n1,nation n2,region "
					+ "where p_partkey = l_partkey and s_suppkey = l_suppkey and l_orderkey = o_orderkey and o_custkey = c_custkey and c_nationkey = n1.n_nationkey "
					+ "and n1.n_regionkey = r_regionkey and r_name = '"+paraQ08[paraID][1] +"' and s_nationkey = n2.n_nationkey and o_orderdate between date ('1995-01-01') and "
					+ "date ('1996-12-31') and p_type = '"+paraQ08[paraID][2] +"') as all_nations group by o_year order by o_year;";
			break;
		case 9:
			sql = "select nation,o_year,sum(amount) as sum_profit from (select n_name as nation,extract(year from o_orderdate) as o_year,l_extendedprice * (1 - l_discount) - ps_supplycost * l_quantity as amount from part,supplier,lineitem,partsupp,orders,nation where s_suppkey = l_suppkey and ps_suppkey = l_suppkey and ps_partkey = l_partkey and p_partkey = l_partkey and o_orderkey = l_orderkey and s_nationkey = n_nationkey and p_name like '%" +paraQ09[paraID]+"%' ) as profit group by nation,o_year order by nation,o_year desc;";
			sql = "select nation,o_year,sum(amount) as sum_profit from( select n_name as nation,extract(year from o_orderdate) as o_year,l_extendedprice * (1 - l_discount) "
					+ "- ps_supplycost * l_quantity as amount from part,supplier,lineitem,partsupp,orders,nation where s_suppkey = l_suppkey and ps_suppkey = l_suppkey and "
					+ "ps_partkey = l_partkey and p_partkey = l_partkey and o_orderkey = l_orderkey and s_nationkey = n_nationkey and p_name like '%" +paraQ09[paraID]+"%') as profit group "
					+ "by nation,o_year order by nation,o_year desc;";
			break;
		case 10:
			sql = "select c_custkey,c_name,sum(l_extendedprice * (1 - l_discount)) as revenue,c_acctbal,n_name,c_address,c_phone,c_comment from customer,orders,lineitem,"
					+ "nation where c_custkey = o_custkey and l_orderkey = o_orderkey and o_orderdate >= date ('"+paraQ10[paraID] +"') and o_orderdate < date ('"+paraQ10[paraID] +"') and "
					+ "l_returnflag = 'R' and c_nationkey = n_nationkey group by c_custkey,c_name,c_acctbal,c_phone,n_name,c_address,c_comment order by revenue desc;";
			break;
		case 11:
			sql = "select ps_partkey,sum(ps_supplycost * ps_availqty) as value from partsupp,supplier,nation where ps_suppkey = s_suppkey and s_nationkey = n_nationkey "
					+ "and n_name = '"+paraQ11[paraID] +"' group by ps_partkey having sum(ps_supplycost * ps_availqty) > ( select sum(ps_supplycost * ps_availqty) * "+Fraction+""
					+ "from partsupp,supplier,nation where ps_suppkey = s_suppkey and s_nationkey = n_nationkey and n_name = '"+paraQ11[paraID] +"') order by value desc;";
			break;
		case 12:
			sql = "select l_shipmode,sum(case when o_orderpriority = '1-URGENT' or o_orderpriority = '2-HIGH' then 1 else 0 end) as high_line_count, "
					+ "sum(case when o_orderpriority <> '1-URGENT' and o_orderpriority <> '2-HIGH' then 1 else 0 end) as low_line_count from orders,lineitem "
					+ "where o_orderkey = l_orderkey and l_shipmode in ('"+paraQ12[paraID][0]+"') and l_commitdate < l_receiptdate and l_shipdate < l_commitdate and "
					+ "l_receiptdate >= date ('"+paraQ12[paraID][1]+"') and l_receiptdate < date ('"+paraQ12[paraID][1]+"') + interval '1' year group by l_shipmode order by l_shipmode;";
			break;
		case 13:
			sql = "select c_count,count(*) as custdist from ( select c_custkey,count(o_orderkey) from customer left outer join orders on c_custkey = o_custkey and o_comment not"
					+ " like '"+paraQ13[paraID] +"' group by c_custkey) as c_orders (c_custkey, c_count) group by c_count order by custdist desc,c_count desc;";
			break;
		case 14:
			sql = "select 100.00 * sum(case when p_type like 'PROMO%' then l_extendedprice * (1 - l_discount) else 0 end) / sum(l_extendedprice * (1 - l_discount)) as "
					+ "promo_revenue from lineitem,part where l_partkey = p_partkey and l_shipdate >= date ('"+paraQ14[paraID]+"') and l_shipdate < date ('"+paraQ14[paraID]+"') + interval '1' month;";
			break;
		case 15:
			sql = "select * from region";
			break;
		case 16:
			sql = "select p_brand,p_type,p_size,count(distinct ps_suppkey) as supplier_cnt from partsupp,part where p_partkey = ps_partkey and"
					+ " p_brand <> '"+paraQ16[paraID][0]+"' and p_type not like '"+paraQ16[paraID][1]+"%' and p_size in ("+paraQ16[paraID][2]+") and ps_suppkey not in"
					+ " ( select s_suppkey from supplier where s_comment like '%Customer%Complaints%') group by p_brand,p_type,p_size order by "
					+ "supplier_cnt desc,p_brand,p_type,p_size;";
			break;
		case 17:
			sql = "select  sum(l_extendedprice) / 7.0 as avg_yearly from  lineitem,  part where  p_partkey = l_partkey  and p_brand = '"+paraQ17[paraID][0]+"'  and "
					+ "p_container = '"+paraQ17[paraID][1]+"'  and l_quantity < (   select    0.2 * avg(l_quantity)   from    lineitem   where    l_partkey = p_partkey  );";
			break;
		case 18:
			sql = "select c_name,c_custkey,o_orderkey,o_orderdate,o_totalprice,sum(l_quantity) from customer,orders,lineitem where o_orderkey in "
					+ "( select l_orderkey from lineitem group by l_orderkey having sum(l_quantity) > "+paraQ18[paraID]+") and c_custkey = o_custkey and o_orderkey = l_orderkey group "
					+ "by c_name,c_custkey,o_orderkey,o_orderdate,o_totalprice order by o_totalprice desc,o_orderdate;";
			break;
		case 19:
			sql = "select sum(l_extendedprice* (1 - l_discount)) as revenue from lineitem,part where ( p_partkey = l_partkey and p_brand = '"+paraQ19[paraID][0]+"' "
					+ "and p_container in ('SM CASE', 'SM BOX', 'SM PACK', 'SM PKG')  and l_quantity >= "+paraQ19[paraID][1]+" and l_quantity <= "+paraQ19[paraID][1]+" + 10 and p_size between "
					+ "1 and 5 and l_shipmode in ('AIR', 'AIR REG') and l_shipinstruct = 'DELIVER IN PERSON') or (p_partkey = l_partkey and "
					+ "p_brand = '"+paraQ19[paraID][2]+"' and p_container in ('MED BAG', 'MED BOX', 'MED PKG', 'MED PACK') and l_quantity >= "+paraQ19[paraID][3]+" and"
					+ " l_quantity <= "+paraQ19[paraID][3]+" + 10 and p_size between 1 and 10 and l_shipmode in ('AIR', 'AIR REG') and l_shipinstruct = 'DELIVER IN PERSON')"
					+ " or ( p_partkey = l_partkey and p_brand = '"+paraQ19[paraID][4]+"' and p_container in ('LG CASE', 'LG BOX', 'LG PACK', 'LG PKG') and"
					+ " l_quantity >= "+paraQ19[paraID][5]+" and l_quantity <= "+paraQ19[paraID][5]+" + 10 and p_size between 1 and 15 and l_shipmode in ('AIR', 'AIR REG') and"
					+ " l_shipinstruct = 'DELIVER IN PERSON');";
			break;
		case 20:
			sql = "select s_name,s_address from  supplier,  nation where  s_suppkey in (   select    ps_suppkey   from    partsupp   where    ps_partkey in"
					+ " (     select      p_partkey     from      part     where      p_name like '"+paraQ20[paraID][0]+"%'    )    and ps_availqty > (     select      0.5 * sum(l_quantity)     "
					+ "from      lineitem     where      l_partkey = ps_partkey      and l_suppkey = ps_suppkey      and l_shipdate >= date ('"+paraQ20[paraID][1]+"')      "
					+ "and l_shipdate < date ('"+paraQ20[paraID][1]+"') + interval '1'  year    )  )  and s_nationkey = n_nationkey  and n_name = '"+paraQ20[paraID][2]+"' order by  s_name;";
			break;
		case 21:
			sql = "select s_name,count(*) as numwait from supplier,lineitem l1,orders,nation where s_suppkey = l1.l_suppkey and o_orderkey = l1.l_orderkey and "
					+ "o_orderstatus = 'F' and l1.l_receiptdate > l1.l_commitdate and exists ( select * from lineitem l2 where l2.l_orderkey = l1.l_orderkey and "
					+ "l2.l_suppkey <> l1.l_suppkey ) and not exists ( select * from lineitem l3 where l3.l_orderkey = l1.l_orderkey and l3.l_suppkey <> l1.l_suppkey "
					+ "and l3.l_receiptdate > l3.l_commitdate ) and s_nationkey = n_nationkey and n_name = '"+paraQ21[paraID]+"' group by s_name order by numwait desc,s_name;";
			break;
		case 22:
			sql = "select cntrycode,count(*) as numcust,sum(c_acctbal) as totacctbal from ( select substring(c_phone from 1 for 2)  as cntrycode,c_acctbal from "
					+ "customer where substring(c_phone from 1 for 2) in ("+paraQ22[paraID]+") and c_acctbal > ( select avg(c_acctbal) from customer "
					+ "where c_acctbal > 0.00 and substring(c_phone from 1 for 2)  in ("+paraQ22[paraID]+") ) and not exists ( select * from orders "
					+ "where o_custkey = c_custkey ) ) as custsale group by cntrycode order by cntrycode;";
			break;
		case 23:
			sql = "select sum(l_quantity),sum(l_extendedprice) from lineitem_part;";
			//sql="select count(l_shipinstruct) from probe;";
			break;
		case 24:
			sql = "select avg(l_quantity),avg(l_extendedprice),avg(l_discount)from lineitem_part;";
			//sql="select max(l_extendedprice) from probe;";
			break;
		case 25://9-15冬燕修改
			sql = "select l_extendedprice,sum(l_extendedprice * (1 - l_discount)),sum(l_extendedprice * (1 - l_discount) * (1 + l_tax)) from lineitem_part group by l_extendedprice;";
			//sql="select sum(l_quantity) from probe;";
			break;
		case 26:
			sql = "select avg(l_quantity),count(*) from lineitem;";
			//sql="select max(l_extendedprice),count(l_shipinstruct) from probe;";
			break;
		case 27:
			sql = "select count(*),sum(l_extendedprice  * l_quantity) from lineitem;";
			//sql="select max(l_extendedprice),count(l_shipinstruct),sum(l_quantity) from probe;";
			break;
		case 28:
			sql = "select sum(l_extendedprice  * l_quantity),avg(l_quantity),avg(l_extendedprice),avg(l_discount) from lineitem ;";
			//sql="select count(o_totalprice),max(o_totalprice),sum(o_totalprice) from orders;";
			break;
		case 29:
			sql = "select l_quantity from lineitem_part where l_comment =  'comment' ;";//
			//sql="select sum(o_totalprice) from orders;";
			break;
		case 30:
			sql = "select l_discount,l_tax,l_linenumber,l_quantity,l_extendedprice from lineitem_part where l_orderkey =  2456423;";
			//09-15冬燕修改  sql = "select l_quantity,l_extendedprice from lineitem_part where l_comment = 'ship';";
			//sql="select *  from probe limit "+paraQ23[paraID]+" ;";
			break;
		case 31:
			sql = "select l_quantity,l_extendedprice,l_discount,l_tax,l_linenumber from lineitem where l_orderkey =  2456423;";
			//sql="select count(o_totalprice),max(o_totalprice),sum(o_totalprice) from orders;";
			break;*/	
		case 1:
			sql = "select s_acctbal,s_name,n_name,p_partkey,p_mfgr,s_address,s_phone,s_comment from part,supplier,partsupp,nation,region"
					+ " where p_partkey = ps_partkey and s_suppkey = ps_suppkey and p_size = "+paraQ01[paraID][0]+" and p_type like '%"+paraQ01[paraID][1]+"' and s_nationkey = n_nationkey "
					+ "and n_regionkey = r_regionkey and r_name = '" +paraQ01[paraID][2] + "' and ps_supplycost = (select min(ps_supplycost) from partsupp,supplier,nation,region "
					+ "where p_partkey = ps_partkey and s_suppkey = ps_suppkey and s_nationkey = n_nationkey and n_regionkey = r_regionkey and r_name ='" +paraQ01[paraID][2]+ "') "
					+ "order by s_acctbal desc,n_name,s_name,p_partkey;";
			break;
		case 2:
			sql = "/*+ IndexScan(partsupp)*/select s_acctbal,s_name,n_name,p_partkey,p_mfgr,s_address,s_phone,s_comment from part,supplier,partsupp,nation,region"
					+ " where p_partkey = ps_partkey and s_suppkey = ps_suppkey and p_size = "+paraQ02[paraID][0]+" and p_type like '%"+paraQ02[paraID][1]+"' and s_nationkey = n_nationkey "
					+ "and n_regionkey = r_regionkey and r_name = '" +paraQ02[paraID][2] + "' and ps_supplycost = (select min(ps_supplycost) from partsupp,supplier,nation,region "
					+ "where p_partkey = ps_partkey and s_suppkey = ps_suppkey and s_nationkey = n_nationkey and n_regionkey = r_regionkey and r_name ='" +paraQ02[paraID][2]+ "') "
					+ "order by s_acctbal desc,n_name,s_name,p_partkey;";
			break;
		case 3:
			sql = "/*+ SeqScan(part)*/select s_acctbal,s_name,n_name,p_partkey,p_mfgr,s_address,s_phone,s_comment from part,supplier,partsupp,nation,region"
					+ " where p_partkey = ps_partkey and s_suppkey = ps_suppkey and p_size = "+paraQ03[paraID][0]+" and p_type like '%"+paraQ03[paraID][1]+"' and s_nationkey = n_nationkey "
					+ "and n_regionkey = r_regionkey and r_name = '" +paraQ03[paraID][2] + "' and ps_supplycost = (select min(ps_supplycost) from partsupp,supplier,nation,region "
					+ "where p_partkey = ps_partkey and s_suppkey = ps_suppkey and s_nationkey = n_nationkey and n_regionkey = r_regionkey and r_name ='" +paraQ03[paraID][2]+ "') "
					+ "order by s_acctbal desc,n_name,s_name,p_partkey;";
			break;
		case 4:
			sql = "select l_orderkey,sum(l_extendedprice * (1 - l_discount)) as revenue,o_orderdate,o_shippriority from customer,orders,lineitem where c_mktsegment = '"+paraQ04[paraID][0]+"' "
					+ "and c_custkey = o_custkey and l_orderkey = o_orderkey and o_orderdate < date ('"+paraQ04[paraID][1]+ "') and l_shipdate > date ('"+paraQ04[paraID][1]+"') group by "
					+ "l_orderkey,o_orderdate,o_shippriority order by revenue desc,o_orderdate;";
			break;
		case 5:
			sql = "/*+ IndexScan(customer customer_pkey)*/select l_orderkey,sum(l_extendedprice * (1 - l_discount)) as revenue,o_orderdate,o_shippriority from customer,orders,lineitem where c_mktsegment = '"+paraQ05[paraID][0]+"' "
					+ "and c_custkey = o_custkey and l_orderkey = o_orderkey and o_orderdate < date ('"+paraQ05[paraID][1]+ "') and l_shipdate > date ('"+paraQ05[paraID][1]+"') group by "
					+ "l_orderkey,o_orderdate,o_shippriority order by revenue desc,o_orderdate;";
			break;
		case 6:
			sql = "/*+ MergeJoin(orders lineitem)*/select l_orderkey,sum(l_extendedprice * (1 - l_discount)) as revenue,o_orderdate,o_shippriority from customer,orders,lineitem where c_mktsegment = '"+paraQ06[paraID][0]+"' "
					+ "and c_custkey = o_custkey and l_orderkey = o_orderkey and o_orderdate < date ('"+paraQ06[paraID][1]+ "') and l_shipdate > date ('"+paraQ06[paraID][1]+"') group by "
					+ "l_orderkey,o_orderdate,o_shippriority order by revenue desc,o_orderdate;";
			break;
		case 7:
			sql = "select o_orderpriority,count(*) as order_count from orders where o_orderdate >= date ('1993-7-1') and o_orderdate < date ('"+paraQ07[paraID] +"') "
					+ "+ interval '3' month and exists ( select * from lineitem where l_orderkey = o_orderkey and l_commitdate < l_receiptdate) group by o_orderpriority "
					+ "order by o_orderpriority;";
			break;
		case 8:
			sql = "/*+ IndexScan(lineitem)*/select o_orderpriority,count(*) as order_count from orders where o_orderdate >= date ('1993-7-1') and o_orderdate < date ('"+paraQ08[paraID] +"') "
					+ "+ interval '3' month and exists ( select * from lineitem where l_orderkey = o_orderkey and l_commitdate < l_receiptdate) group by o_orderpriority "
					+ "order by o_orderpriority;";
			break;
		case 9:
			sql = "/*+ NoHashJoin(orders lineitem)*/select o_orderpriority,count(*) as order_count from orders where o_orderdate >= date ('1993-7-1') and o_orderdate < date ('"+paraQ09[paraID] +"') "
					+ "+ interval '3' month and exists ( select * from lineitem where l_orderkey = o_orderkey and l_commitdate < l_receiptdate) group by o_orderpriority "
					+ "order by o_orderpriority;";
			break;
		case 10:
			sql = "select c_custkey,c_name,sum(l_extendedprice * (1 - l_discount)) as revenue,c_acctbal,n_name,c_address,c_phone,c_comment from customer,orders,lineitem,"
					+ "nation where c_custkey = o_custkey and l_orderkey = o_orderkey and o_orderdate >= date ('"+paraQ10[paraID] +"') and o_orderdate < date ('"+paraQ10[paraID] +"') and "
					+ "l_returnflag = 'R' and c_nationkey = n_nationkey group by c_custkey,c_name,c_acctbal,c_phone,n_name,c_address,c_comment order by revenue desc;";
			break;
		case 11:
			sql = "/*+ IndexScan(orders orders_pkey)*/select c_custkey,c_name,sum(l_extendedprice * (1 - l_discount)) as revenue,c_acctbal,n_name,c_address,c_phone,c_comment from customer,orders,lineitem,"
					+ "nation where c_custkey = o_custkey and l_orderkey = o_orderkey and o_orderdate >= date ('"+paraQ11[paraID] +"') and o_orderdate < date ('"+paraQ11[paraID] +"') and "
					+ "l_returnflag = 'R' and c_nationkey = n_nationkey group by c_custkey,c_name,c_acctbal,c_phone,n_name,c_address,c_comment order by revenue desc;";
			break;
		case 12:
			sql = "/*+ NoNestLoop(orders customer)*/select c_custkey,c_name,sum(l_extendedprice * (1 - l_discount)) as revenue,c_acctbal,n_name,c_address,c_phone,c_comment from customer,orders,lineitem,"
					+ "nation where c_custkey = o_custkey and l_orderkey = o_orderkey and o_orderdate >= date ('"+paraQ12[paraID] +"') and o_orderdate < date ('"+paraQ12[paraID] +"') and "
					+ "l_returnflag = 'R' and c_nationkey = n_nationkey group by c_custkey,c_name,c_acctbal,c_phone,n_name,c_address,c_comment order by revenue desc;";
			break;
		case 13:
			sql = "select 100.00 * sum(case when p_type like 'PROMO%' then l_extendedprice * (1 - l_discount) else 0 end) / sum(l_extendedprice * (1 - l_discount)) as "
					+ "promo_revenue from lineitem,part where l_partkey = p_partkey and l_shipdate >= date ('"+paraQ13[paraID]+"') and l_shipdate < date ('"+paraQ13[paraID]+"') + interval '1' month;";
			break;
		case 14:
			sql = "/*+ IndexScan(part)*/select 100.00 * sum(case when p_type like 'PROMO%' then l_extendedprice * (1 - l_discount) else 0 end) / sum(l_extendedprice * (1 - l_discount)) as "
					+ "promo_revenue from lineitem,part where l_partkey = p_partkey and l_shipdate >= date ('"+paraQ14[paraID]+"') and l_shipdate < date ('"+paraQ14[paraID]+"') + interval '1' month;";
			break;
		case 15:
			sql = "/*+ NoHashJoin(lineitem part)*/select 100.00 * sum(case when p_type like 'PROMO%' then l_extendedprice * (1 - l_discount) else 0 end) / sum(l_extendedprice * (1 - l_discount)) as "
					+ "promo_revenue from lineitem,part where l_partkey = p_partkey and l_shipdate >= date ('"+paraQ15[paraID]+"') and l_shipdate < date ('"+paraQ15[paraID]+"') + interval '1' month;";
			break;
		case 16:
			sql = "select cntrycode,count(*) as numcust,sum(c_acctbal) as totacctbal from ( select substring(c_phone from 1 for 2)  as cntrycode,c_acctbal from "
					+ "customer where substring(c_phone from 1 for 2) in ("+paraQ16[paraID]+") and c_acctbal > ( select avg(c_acctbal) from customer "
					+ "where c_acctbal > 0.00 and substring(c_phone from 1 for 2)  in ("+paraQ16[paraID]+") ) and not exists ( select * from orders "
					+ "where o_custkey = c_custkey ) ) as custsale group by cntrycode order by cntrycode;";
			break;
		case 17:
			sql = "/*+ NoSeqScan(orders) NoSeqScan(customer)*/select cntrycode,count(*) as numcust,sum(c_acctbal) as totacctbal from ( select substring(c_phone from 1 for 2)  as cntrycode,c_acctbal from "
					+ "customer where substring(c_phone from 1 for 2) in ("+paraQ17[paraID]+") and c_acctbal > ( select avg(c_acctbal) from customer "
					+ "where c_acctbal > 0.00 and substring(c_phone from 1 for 2)  in ("+paraQ17[paraID]+") ) and not exists ( select * from orders "
					+ "where o_custkey = c_custkey ) ) as custsale group by cntrycode order by cntrycode;";
			break;
		case 18:
			sql = "/*+ NoHashJoin(customer orders)*/select cntrycode,count(*) as numcust,sum(c_acctbal) as totacctbal from ( select substring(c_phone from 1 for 2)  as cntrycode,c_acctbal from "
					+ "customer where substring(c_phone from 1 for 2) in ("+paraQ18[paraID]+") and c_acctbal > ( select avg(c_acctbal) from customer "
					+ "where c_acctbal > 0.00 and substring(c_phone from 1 for 2)  in ("+paraQ18[paraID]+") ) and not exists ( select * from orders "
					+ "where o_custkey = c_custkey ) ) as custsale group by cntrycode order by cntrycode;";
			break;

		case 23:
			sql = "select sum(l_quantity),sum(l_extendedprice) from lineitem_part;";
			//sql="select count(l_shipinstruct) from probe;";
			break;
		case 24:
			sql = "select avg(l_quantity),avg(l_extendedprice),avg(l_discount)from lineitem_part;";
			//sql="select max(l_extendedprice) from probe;";
			break;
		case 25://9-15冬燕修改
			sql = "select l_extendedprice,sum(l_extendedprice * (1 - l_discount)),sum(l_extendedprice * (1 - l_discount) * (1 + l_tax)) from lineitem_part group by l_extendedprice;";
			//sql="select sum(l_quantity) from probe;";
			break;
		case 26:
			sql = "select avg(l_quantity),count(*) from lineitem;";
			//sql="select max(l_extendedprice),count(l_shipinstruct) from probe;";
			break;
		case 27:
			sql = "select count(*),sum(l_extendedprice  * l_quantity) from lineitem;";
			//sql="select max(l_extendedprice),count(l_shipinstruct),sum(l_quantity) from probe;";
			break;
		case 28:
			sql = "select sum(l_extendedprice  * l_quantity),avg(l_quantity),avg(l_extendedprice),avg(l_discount) from lineitem ;";
			//sql="select count(o_totalprice),max(o_totalprice),sum(o_totalprice) from orders;";
			break;
		case 29:
			sql = "select l_quantity from lineitem_part where l_comment =  'comment' ;";//
			//sql="select sum(o_totalprice) from orders;";
			break;
		case 30:
			sql = "select l_discount,l_tax,l_linenumber,l_quantity,l_extendedprice from lineitem_part where l_orderkey =  2456423;";
			//09-15冬燕修改  sql = "select l_quantity,l_extendedprice from lineitem_part where l_comment = 'ship';";
			//sql="select *  from probe limit "+paraQ23[paraID]+" ;";
			break;
		case 31:
			sql = "select l_quantity,l_extendedprice,l_discount,l_tax,l_linenumber from lineitem where l_orderkey =  2456423;";
			//sql="select count(o_totalprice),max(o_totalprice),sum(o_totalprice) from orders;";
			break;
		default:
			sql = "";
			break;
		}
		return sql;
	}
	
	public String getSnapString(int tempID){//tempID, 都是从1开始计数。
		String sql = null;
//		String sqlsnap1 = "'select l_returnflag,l_linestatus%'";
		String sqlsnap1 = "'select s_acctbal%'";
		String sqlsnap2 = "'select s_acctbal%'";
		String sqlsnap3 = "'select l_orderkey%'";//与Q18有重复，需测试
		String sqlsnap4 = "'select o_orderpriority%'";
		String sqlsnap5 = "'select n_name,sum%'";
		String sqlsnap6 = "'select sum(l_extendedprice * l_discount)%'";
		String sqlsnap7 = "'select supp_nation%'";
		String sqlsnap8 = "'select o_year,sum%'";
		String sqlsnap9 = "'select nation,o_year%'";
		String sqlsnap10 = "'select c_custkey%'";//与Q13有重复
		String sqlsnap11 = "'select ps_partkey%'";
		String sqlsnap12 = "'select l_shipmode%'";
		String sqlsnap13 = "'select c_count,count%'";
		String sqlsnap14 = "'select ? * sum%'";//PG会把sql中的参数用？表示
		String sqlsnap15 = "'%'";
		String sqlsnap16 = "'select p_brand%'";
		String sqlsnap17 = "'select  sum(l_extendedprice)%'";
		String sqlsnap18 = "'select c_name,c_custkey%'";
		String sqlsnap19 = "'select sum(l_extendedprice* (? - l_discount)%'";//PG会把sql中的参数用？表示
		String sqlsnap20 = "'select s_name,s_address%'";
		String sqlsnap21 = "'select s_name,count(*)%'";
		String sqlsnap22 = "'select cntrycode,count(*)%'";
		String sqlsnap23 = "'%sum(l_quantity),sum(l_extendedprice)%'";
		String sqlsnap24 = "'%avg(l_quantity),avg(l_extendedprice),avg(l_discount)%'";
		String sqlsnap25 = "'%l_extendedprice,sum(l_extendedprice * (1 - l_discount)),sum(l_extendedprice * (1 - l_discount) * (1 + l_tax))%'";
		String sqlsnap26 = "'%avg(l_quantity),count(*)%'";
		String sqlsnap27 = "'%count(*),sum(l_extendedprice  * l_quantity)%'";
		String sqlsnap28 = "'%sum(l_extendedprice  * l_quantity),avg(l_quantity),avg(l_extendedprice),avg(l_discount) from lineitem%'";
		String sqlsnap29 = "'%l_quantity from lineitem_part where l_comment%'";
		String sqlsnap30 ="'%l_discount,l_tax,l_linenumber,l_quantity,l_extendedprice from lineitem_part%'";// "'%l_quantity,l_extendedprice%'";
		String sqlsnap31 = "'%l_quantity,l_extendedprice,l_discount,l_tax,l_linenumber from lineitem%'";
		
		String temp = "select queryid,userid,dbid,calls,total_time,rows,shared_blks_hit,shared_blks_read,blk_read_time,shared_blks_dirtied,shared_blks_written,local_blks_hit,local_blks_read,local_blks_dirtied,local_blks_written,temp_blks_read,temp_blks_written,blk_write_time,query"
				+ " from pg_stat_statements where dbid = "+dbid +" and userid = "+userid +" and query like ";
		switch (tempID) {
		case 1:
			sql = temp + sqlsnap1;
			break;
		case 2:
			sql = temp + sqlsnap2;
			break;
		case 3:
			sql = temp + sqlsnap3;
			break;
		case 4:
			sql = temp + sqlsnap4;
			break;
		case 5:
			sql = temp + sqlsnap5;
			break;
		case 6:
			sql = temp + sqlsnap6;
			break;
		case 7:
			sql = temp + sqlsnap7;
			break;
		case 8:
			sql = temp + sqlsnap8;
			break;
		case 9:
			sql = temp + sqlsnap9;
			break;
		case 10:
			sql = temp + sqlsnap10;
			break;
		case 11:
			sql = temp + sqlsnap11;
			break;
		case 12:
			sql = temp + sqlsnap12;
			break;
		case 13:
			sql = temp + sqlsnap13;
			break;
		case 14:
			sql = temp + sqlsnap14;
			break;
		case 15:
			sql = temp +sqlsnap15;
			break;
		case 16:
			sql = temp + sqlsnap16;
			break;
		case 17:
			sql = temp + sqlsnap17;
			break;
		case 18:
			sql = temp + sqlsnap18;
			break;
		case 19:
			sql = temp + sqlsnap19;
			break;
		case 20:
			sql = temp + sqlsnap20;
			break;
		case 21:
			sql = temp + sqlsnap21;
			break;
		case 22:
			sql = temp + sqlsnap22;
			break;
		case 23:
			sql = temp + sqlsnap23;
			break;
		case 24:
			sql = temp + sqlsnap24;
			break;
		case 25:
			sql = temp + sqlsnap25;
			break;
		case 26:
			sql = temp + sqlsnap26;
			break;
		case 27:
			sql = temp + sqlsnap27;
			break;
		case 28:
			sql = temp + sqlsnap28;
			break;
		case 29:
			sql = temp + sqlsnap29;
			break;
		case 30:
			sql = temp + sqlsnap30;
			break;
		case 31:
			sql = temp + sqlsnap31;
			break;
		default:
			sql = "";
			break;
		}
		return sql;
	}
	public static void main(String[] args) throws Exception{
		QueryText qText = new QueryText(1,"12373","17136");//SF因子，数据库id，userid
		System.out.println(qText.getQueryString(15,2));
		System.out.println(qText.getQueryString(15,1));
		System.out.println(qText.getSnapString(15));
		
		/*System.out.print(qText.paraQ01.length+",");
		System.out.print(qText.paraQ02.length+",");
		System.out.print(qText.paraQ03.length+",");
		System.out.print(qText.paraQ04.length+",");
		System.out.print(qText.paraQ05.length+",");
		System.out.print(qText.paraQ06.length+",");
		System.out.print(qText.paraQ07.length+",");
		System.out.print(qText.paraQ08.length+",");
		System.out.print(qText.paraQ09.length+",");
		System.out.print(qText.paraQ10.length+",");
		System.out.print(qText.paraQ11.length+",");
		System.out.print(qText.paraQ12.length+",");
		System.out.print(qText.paraQ13.length+",");
		System.out.print(qText.paraQ14.length+",");
		System.out.print(qText.paraQ16.length+",");
		System.out.print(qText.paraQ17.length+",");
		System.out.print(qText.paraQ18.length+",");
		System.out.print(qText.paraQ19.length+",");
		System.out.print(qText.paraQ20.length+",");
		System.out.print(qText.paraQ21.length+",");
		System.out.print(qText.paraQ22.length+",");*/
	}
}
