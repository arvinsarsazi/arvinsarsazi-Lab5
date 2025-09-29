public class Enigma{

    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};


    private Rotor rotors[];
        
    public Enigma(int id1, int id2, int id3, String start){

        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));
        
    }

    public char charEncrypt(char c) {

        int inrotor_index = rotors[0].indexOf(c);
        char outrotor_char = rotors[2].charAt(inrotor_index);
        int midrotor_index = rotors[1].indexOf(outrotor_char);
        char result = rotors[2].charAt(midrotor_index);
        rotate();
        return result;

    }

    public char charDecrypt(char c) {

        int outrotor_index = rotors[2].indexOf(c);
        char midrotor_char = rotors[1].charAt(outrotor_index);
        int outrotor_index2 = rotors[2].indexOf(midrotor_char);
        char result = rotors[0].charAt(outrotor_index2);
        rotate();
        return result;

    }

    public String decrypt(String message){      

        char[] array = new char[message.length()];
        for (int i = 0; i < message.length(); i++) {
            array[i] = charDecrypt(message.charAt(i));
        }
        message = String.valueOf(array);
        return message;
    }


    
    public String encrypt(String message){

        char[] array = new char[message.length()];
        for (int i = 0; i < message.length(); i++) {
            array[i] = charEncrypt(message.charAt(i));
        }
        message = String.valueOf(array);
        return message;

    }

    
    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
    
}
