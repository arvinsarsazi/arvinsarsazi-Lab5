public class Rotor {

    
    private String rotorValues;
    private char startChar;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        
        while(!this.rotate());
            
    }
    
    public boolean rotate(){

        char last = rotorValues.charAt(rotorValues.length() - 1);
        rotorValues = last + rotorValues.substring(0, rotorValues.length() - 1);
        if (last == startChar) {
            return true;
        }
        return false;

    }
    

    public int indexOf(char c){
        for (int i = 0; i < rotorValues.length(); i++) {
            if (rotorValues.charAt(i) == c) {
                return i;
            }
        }
        return -1;
    }

    public char charAt(int idx){
        return rotorValues.charAt(idx);
    }
}
    
