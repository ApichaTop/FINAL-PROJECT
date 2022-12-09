import javax.swing.*;
public class Test {
    public static void main(String[] args) throws Exception{ // จุดที่โปรแกรมเริ่มต้นการทำงาน
        String choice;
        int c = 0;
        Person p;
        Test test = new Test();
        Object obj;
        ArrayList list = new ArrayList();
        while (c != 9){
            try{
                choice = JOptionPane.showInputDialog(null,
                        "-------------------Menu-----------------------"+
                "\n"+
                        "1. Insert Your Information\n"+
                        "2. Show Your Information\n"+
                        "3. Delete\n"+
                        "4. Update\n"+
                        "5. BMI Calculate\n"+
                        "6. FindFirst\n"+
                        "7. FindNext\n"+
                        "8. Bmi sort \n"+
                        "9. Exit\n"+
                        "---------------------------------\n");
                c =Integer.parseInt(choice);
                switch (c){
                    case 1: // เรียกใช้การเพิ่มข้อมูลลง arraylist
                        p = test.getElement();
                        obj = p;
                        list.insert(p);
                        break;
                    case 2: // เรียกใช้การดึงข้อมูลจากใน arraylist
                        obj = list.retrieve();
                        p = (Person) obj;
                        test.printElement(p);
                        break;
                    case 3: // เรียกใช้การลบข้อมูลออกจาก arraylist
                        list.delete();
                        break;
                    case 4: // เรียกใช้การ update ข้อมูลตัวนั้นๆใน arraylist
                        p = test.getElement();
                        obj = p;
                        list.update(p);
                        break;
                    case 5: // เรียกใช้ การ คำนวณ bmi ข้อมูลตัวปัจจุบันใน arraylist
                        obj = list.retrieve();
                        p = (Person) obj;
                        test.bmical(p);
                        break;
                    case 6: // เรียกใช้ หาข้อมูลตัวแรกสุดของข้อมูล arraylist
                        list.findFirst();
                        break;
                    case 7: // เรียกใช้ หาข้อมูลตัวถัดไปจากข้อมูลตัวปัจจุบันใน arraylist
                        list.findNext();
                        break;
                    case 8: // เรียกใช้ sort ข้อมูลจาก bmi
                        list.sort();
                        list.findFirst();
                        String text="";
                        for(int i=0;i< list.size;i++){
                            text+=list.retrieve().getName()+" : BMI = "+String.format("%,.2f",list.retrieve().getBMI())+"\n";
                            list.findNext();
                        }
                        JOptionPane.showMessageDialog(null, text+"\n\n", "BMI sort",JOptionPane.PLAIN_MESSAGE);
                        break;
                    case 9: // เรียกใช้ การออกจากทำงานของโปรแกรม
                        JOptionPane.showMessageDialog(null,
                                "----------End Program ----------",
                                "Quit",
                                JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                        break;
                 }
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
        }
    }
    public Person getElement(){        //รับค่า input จากผู้ใช้
        Person tmp;
        String names = JOptionPane.showInputDialog(null,"Insert Name :");   //รับค่า ชื่อจากผู้ใช้
        String genders = JOptionPane.showInputDialog(null,"Insert Gender :"); //รับค่า เพศจากผู้ใช้
        double weights = Double.parseDouble(JOptionPane.showInputDialog(null,"Insert weights")); //รับค่า น้ำหนักจากผู้ใช้
        double heights = Double.parseDouble(JOptionPane.showInputDialog(null,"Insert height(meters)"));//รับค่า ส่วนสูงแบบเมตรจากผู้ใช้
        tmp = new Person();
        tmp.setPerson(names,genders,weights,heights);
        return tmp;
    }
    public void printElement(Person e){ //ใช้แสดงค่าที่input เข้าไป
        if(e != null){
            JOptionPane.showMessageDialog(null,"Name        : "+e.getName()+
                    "\n Gender :" + e.getGender()+
                    "\n Weight :" + e.getWeight()+
                    "\n Height : " + e.getHeight());
        }
    }
    public void bmical(Person e){//ส่วนนี้ใช้เพื่อแสดงค่าว่า BMI อยู่ในเกณฑ์ไหน
        if(e != null){
            if (e.getBMI() < 18.5) {      // เงื่อนไข ถ้า BMI น้อยกว่า 18.5 จะให้แสดงผลดังด้านล่าง
                JOptionPane.showMessageDialog(null,"Name        : "+e.getName()+    //แสดงชื่อ
                    "\n Gender : " + e.getGender()+           //แสดง แสดงเพศ
                    "\n Weight : " + e.getWeight()+           //แสดงน้ำหนัก
                    "\n Height : " + e.getHeight()+           //แสดงส่วนสูง
                    "\n BMI :" + String.format("%,.2f",e.getBMI())+                 //แสดงผล BMI ที่คำนวณได้พร้อมปัดทศนิยมเหลือ2หลัก
                    "\n BMI Status : Underweight");          // ถ้าอยู่ในเงื่อนไขจะแสดงเกณฑ์ BMI ว่าต่ำว่าเกณฑ์
            }
            else if (e.getBMI() < 25) {  // เงื่อนไข ถ้า BMI มากกว่า 18.5 แต่น้อยกว่า 25 จะให้แสดงผลดังด้านล่าง
                JOptionPane.showMessageDialog(null,"Name        : "+e.getName()+
                    "\n Gender : " + e.getGender()+
                    "\n Weight : " + e.getWeight()+
                    "\n Height : " + e.getHeight()+
                    "\n BMI :" + String.format("%,.2f",e.getBMI())+
                    "\n BMI Status : Normal");
            }
            else if (e.getBMI() < 30) {      // เงื่อนไข ถ้า BMI มากกว่า 25 แต่น้อยกว่า 30 จะให้แสดงผลดังด้านล่าง
                JOptionPane.showMessageDialog(null,"Name        : "+e.getName()+
                    "\n Gender : " + e.getGender()+
                    "\n Weight : " + e.getWeight()+
                    "\n Height : " + e.getHeight()+
                    "\n BMI :" + String.format("%,.2f",e.getBMI())+
                    "\n BMI Status : Overweight");
            }
            else { // เงื่อนไข ถ้า BMI มากกว่า 30 จะให้แสดงผลดังด้านล่าง
                JOptionPane.showMessageDialog(null,"Name        : "+e.getName()+
                    "\n Gender : " + e.getGender()+
                    "\n Weight : " + e.getWeight()+
                    "\n Height : " + e.getHeight()+
                    "\n BMI :" + String.format("%,.2f",e.getBMI())+
                    "\n BMI Status : Obese");
            }
        }
    }
}
