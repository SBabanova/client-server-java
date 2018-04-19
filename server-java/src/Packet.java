public class Packet {
    private static int num_of_packets = 0;
    private int number;
    private String data;

    Packet(String data){
        this.data = data;
        number = num_of_packets++;
    }

    String getData(){
        return data;
    }

    int getNumber(){
        return number;
    }
}
