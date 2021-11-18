package controller;

public class DocTien {
	 private static String readGroup(String group){
	        String[] readDigit = {" Không", " Một", " Hai", " Ba", " Bốn", " Năm", " Sáu", " Bảy", " Tám", " Chín" };
	        String temp = "";
	        if (group == "000") return "";
	        //read number hundreds
	        temp = readDigit[Integer.parseInt(group.substring(0,1))] + " Trăm";
	        //read number tens
	        if (group.substring(1,2).equals("0"))
	            if (group.substring(2,3).equals("0")) return temp;
	            else
	            {
	                temp += " Lẻ" + readDigit[Integer.parseInt(group.substring(2,3))];
	                return temp;
	            }
	        else
	            temp += readDigit[Integer.parseInt(group.substring(1,2))] + " Mươi";
	        //read number

	        if (group.substring(2,3) == "5") temp += " Lăm";
	        else if (group.substring(2,3) != "0") temp += readDigit[Integer.parseInt(group.substring(2,3))];
	        return temp;
	    }

	    public String readMoney(String num){
	    	if((num==null)||(num.equals(""))) return "";
	    	String temp = "";

	        //length <= 18
	        while (num.length() < 18)
	        {
	        	num = "0" + num;
	        }

	        String g1 = num.substring(0, 3);
	        String g2 = num.substring(3, 6);
	        String g3 = num.substring(6, 9);
	        String g4 = num.substring(9, 12);
	        String g5 = num.substring(12,15);
	        String g6 = num.substring(15,18);

	        //read group1 ---------------------
	        if (!g1.equals("000")){
	            temp = readGroup(g1);
	            temp += " Triệu";
	        }
	        //read group2-----------------------
	        if (!g2.equals("000")){
	            temp += readGroup(g2);
	            temp += " Nghìn";
	        }
	        //read group3 ---------------------
	        if (!g3.equals("000")){
	            temp += readGroup(g3);
	            temp += " Tỷ";
	        } else if(!"".equals(temp)){
	        	temp += " Tỷ";
	        }
	        
	        //read group2-----------------------
	        if (!g4.equals("000")){
	            temp += readGroup(g4);
	            temp += " Triệu";
	        }
	        //---------------------------------
	        if (!g5.equals("000")){
	            temp += readGroup(g5);
	            temp += " Nghìn";
	        }
	        //-----------------------------------

	        temp = temp + readGroup(g6);
	        //---------------------------------
	        // Refine
	        temp = temp.replaceAll("Một Mươi", "Mười");
	        temp = temp.trim();
	        temp = temp.replaceAll("Không Trăm", "");
//	        if (temp.indexOf("Không Trăm") == 0) temp = temp.substring(10);
	        temp = temp.trim();
	        temp = temp.replaceAll("Mười Không", "Mười");
	        temp = temp.trim();
	        temp = temp.replaceAll("Mươi Không", "Mươi");
	        temp = temp.trim();
	        if (temp.indexOf("Lẻ")==0) temp = temp.substring(2);
	        temp = temp.trim();
	        temp = temp.replaceAll("Mươi Một", "Mươi Mốt");
	        temp = temp.trim();
	        
	        //Change Case
	        return temp.substring(0, 1).toUpperCase() + temp.substring(1).toLowerCase() + " đồng.";
	    }
	    
//	    public static void main(String[] args) {
//	    	System.out.println(readGroup("18301"));
//		}
}
