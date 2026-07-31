class Solution {
    public int getValidIndex(String st, int index){
        int backSpace = 0;
        while(index>=0){
            if(st.charAt(index) =='#') backSpace++;
            else if(backSpace > 0){
                backSpace--;
            }else{
                return index;
            }
            index--;
        }
        return -1;
    }

    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        while(i>=0 || j>=0){
            i = getValidIndex(s, i);
            j = getValidIndex(t, j);

            // If one string has no valid character left but the other does,
            // they can't be equal.
            if((i>=0)!=(j>=0)) return false;

            // If both have valid characters but they are different,
            // they can't be equal.
            else if(i>=0 && s.charAt(i)!=t.charAt(j)) return false;

            // Otherwise, we've matched this pair of characters,
            // so move left and repeat.
            i--;
            j--;
        }
        return true;
    }
}