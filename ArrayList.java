public class ArrayList implements ListADT{
    private int total; // ประกาศตัวแปร int ชื่อ total
    private Person s[]; // ประกาศสร้าง list ชื่อ s
    int current,size,bmi,h,w;// ประกาศตัวแปร int ชื่อ current size bmi h w


    public ArrayList()
    {
        List();
    }
    public void List() // โครงสร้างของ list
    {
        current = -1; 
        total = 100;
        s = new Person[total];
        size = 0 ;
    }

    @Override
    public void insert(Person e) throws Exception {   //insert เอาไว้สำหรับให้ผู้ใช้บรรจุค่าลงไปใน list
        if(isFull()){
            throw new Exception("List is full");
        }else {
            size++;
            if(size == 1){
                current++;
                s[current]=e;
            }else {
                for (int i = size-1; i > current ; i--) {
                    s[i] = s[i-1];
                    current++;
                    s[current] = e;
                }
            }
        }
    }

    @Override
    public Person retrieve() throws Exception {   // แสดงค่าที่อยู่ใน list
        if(isEmpty()){
            throw new Exception("List is empty");
        }else {
            return s[current];
        }
    }

    @Override
    public boolean isEmpty() { // ใช้เช็คในกรณีที่ list ว่างจริงไหม?
        if (size == 0){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public void findFirst() throws Exception // มีไว้ให้สามารถกลับมาหาตัวแรกของ list ได้
    {
        if (isEmpty()) {
            throw new Exception("List is empty");
        }else {
            current=0;
        }
    }

    @Override
    public void findNext() throws Exception // มีไว้ให้สามารถไปยังข้อมูลตัวถัดไปจากปัจจุบันใน list ได้
    {
        if (isEmpty())
        {
            throw new Exception("List is empty");
        }else
        {
            if (current != size-1)
                current = current+1;
        }
    }

    @Override
    public void delete() throws Exception {      //ลบค่าที่ใส่เข้าไปใน list ออก
        if(isEmpty()){
            throw new Exception("List is empty");
        }else {
            if (size == 1)
                current = -1;
            else if (current == size-1)
                current = 0;
            else {
                for(int i = current;i<size-1;i++)
                    s[i] = s[i+1];
                current = 0;
            }
            size --;
        }
    }

    @Override
    public void update(Person e) throws Exception {      // update ค่าที่ได้ใส่ลงไปใน list
        s[current] = e;
    }
    

    @Override
    public boolean isFull() { // เงื่อนไขว่า list เต็มแล้วหรือยัง
        if(size == total){
            return true;
        }else {
            return false;
        }
    }
    public void sort() { // เป็นการสั่ง sort จาก bmi
        Person tmp;
        for (int i=0; i<size-1; i++){
            for (int j=0; j<size-i-1; j++)
                if (s[j].getBMI() > s[j+1].getBMI()) {
                    tmp = s[j];
                    s[j] = s[j+1];
                    s[j+1] = tmp;
                }
        }
    }
}
   


    