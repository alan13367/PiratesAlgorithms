import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Table {
    private static final String basePath = "Tables/";
    private static final int[] primes = {11,13,17,19,23,29,31,37,41,43};
    private int numPirates;
    private ArrayList<Pirate>[] pirateList;

    /**
     * Method which extracts the information from the .paed file.
     * @param path the name of the file.
     * @throws FileNotFoundException is thrown when file could not be found.
     */
    public void reader(String path) throws FileNotFoundException {
        File file = new File(basePath + path);
        Scanner scanner = new Scanner(file);
        numPirates = scanner.nextInt();
        scanner.nextLine();
        pirateList = new ArrayList[numPirates];
        for (int i = 0; i < numPirates; i++) {
            pirateList[i] = new ArrayList<>();
        }
        do{
            Pirate curr = new Pirate(scanner.nextLine());
            this.insert(curr);
        }while(scanner.hasNextLine());
        int max = Integer.MIN_VALUE;
        for (ArrayList<Pirate> list : pirateList){
            if(max < list.size()){
                max = list.size();
            }
        }
        System.out.println();
    }

    /**
     * Method to insert a new pirate to the table.
     * @param pirate the pirate that is to be inserted.
     */
    public void insert(Pirate pirate){
        int index = getHash(pirate.getName());
        this.pirateList[index].add(pirate);
    }

    /**
     * Method which gets the pirate from the name.
     * @param name the name of the pirate you want.
     * @return the pirate with the matching name.
     */
    public Pirate get(String name){
        int index = getHash(name);
        for (Pirate curr : pirateList[index]){
            if(curr.getName().equals(name)){
                return curr;
            }
        }
        return null;
    }

    /**
     * Method which deletes the pirate with the provided name.
     * @param name the name of the pirate that needs to be deleted.
     * @return 0 if deleted properly, 1 other wise.
     */
    public int delete(String name){
        int index = getHash(name);
        for (Pirate curr : pirateList[index]){
            if(curr.getName().equals(name)){
                pirateList[index].remove(curr);
                return 0;
            }
        }
        return 1;
    }

    /**
     * Method which generates the hash function according to the name
     * @param name the name of the pirate.
     * @return the hash of the name.
     */
    private int getHash(String name){
        BigInteger out = new BigInteger("7");
        for (int i = 0; i < name.length(); i++) {
            out = out.multiply(BigInteger.valueOf(primes[i%10]));
            out = out.add(BigInteger.valueOf(name.charAt(i)));
        }
        out = out.mod(BigInteger.valueOf(numPirates));
        return out.intValue();
    }

    public int[] getAges (){
        int maxnum = 0;

        for (ArrayList<Pirate> pirArray: pirateList) {
            for (Pirate pirate:pirArray) {
                if(pirate.getAge() > maxnum){
                    maxnum = pirate.getAge();
                }
            }
        }

        int[] ages = new int[maxnum];
        for (ArrayList<Pirate> pirArray: pirateList) {
            for (Pirate pirate:pirArray) {
                ages[pirate.getAge()-1] += 1;
            }
        }

        return ages;
    }

}
