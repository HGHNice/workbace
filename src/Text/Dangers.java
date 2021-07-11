package Text;
    public class Dangers {
        public  static void main(String args[]){
            Machine machine = new Machine();
            Goods goods = new Goods();
            goods.setName("小刀");
            if (goods.getName()=="小刀");
            goods.setDanger(true);
            try {
                machine.checkBag(goods);
            }
            catch (DangerException e){
                System.out.println(e.toshow());
            }
        }
    }
     class Machine {
        void  checkBag(Goods goods) throws DangerException{
            if(goods.isDanger()==true)
            {
                throw new DangerException(goods.name);
            }
        }
    }
     class Goods {
        boolean isDanger;
        String name;
        public boolean isDanger() {
            return isDanger;
        }
        public void setDanger(boolean danger) {
            isDanger = danger;
        }
        void setName(String n) {
            name = n;
        }
        void setISDanger(boolean i){
            isDanger=i;
        }
        public String getName(){
            return name;
        }
    }
     class DangerException extends Exception {
        String message;
        DangerException(String n) {
            message = n + "属于危险品";
        }
        String toshow() {
            return message;
        }
    }