public class Person {
    private String name,gender; //กำหนดให้ name,gender เป็น String
    private double weight,height; // กำหนดให้ weight,height เป็น int
    public Person(String names,String genders,double weights, double heights){ 
        name = names;  // กำหนดให้เก็บไว้ใน names
        gender = genders; // กำหนดให้เก็บไว้ใน genders
        weight = weights; // กำหนดให้เก็บไว้ใน weights
        height = heights;  //// กำหนดให้เก็บไว้ใน heights
    }

    public Person() { // ประกาศไว้เป็นตัวแปรรับข้อมูลจาก input

    }

    public void setPerson(String names,String genders,double weights, double heights){ // สร้าง obj ของ setperson ไว้เรียกใช้ในฟังค์ชั่น getelement
        name = names;
        gender = genders;
        weight = weights;
        height = heights;
    }

    public Person getPerson(){ // สร้างไว้เพื่อเอาไว้คืนค่าของ person ที่ประกอปไปด้วย ชื่อ เพศ น้ำหนัก ส่วนสูง
        Person person = new Person(name,gender,weight,height);
        return person;
    }

    public String getName(){
        return name;
    } //  สร้างไว้เพื่อเอาไว้คืนค่าของ name ใน obj
    public String getGender(){
        return gender;
    } //  สร้างไว้เพื่อเอาไว้คืนค่าของ gender ใน obj
    public double getWeight(){
        return weight;
    } //  สร้างไว้เพื่อเอาไว้คืนค่าของ weight ใน obj
    public double getHeight(){
        return  height; 
    } //  สร้างไว้เพื่อเอาไว้คืนค่าของ height ใน obj

    public double getBMI() {   
        return weight/(Math.pow(height,2));  // ruturnค่า BMI ที่คำนวณด้วยสูตร น้ำหนัก/ส่วนสูง*2 แล้ว
    } 

}

