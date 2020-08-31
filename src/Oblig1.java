import java.util.*;

import static java.util.Arrays.*;

public class Oblig1 {

    // Metoder som generer testverdier til int[] a. Kilde: Kompendie til "appolonius", url. "https://www.cs.hioa.no/~ulfu/appolonius/kap1/1/kap11.html#1.1.2", Programkode 1.1.8 d og e.
    public static void bytt(int[] a, int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int[] randPerm(int n){
        Random r = new Random();

        int[] a = new int[n];
        setAll(a, i -> i + 1);           // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--)         // løkke som går n - 1 ganger
        {
            int i = r.nextInt(k+1);       // en tilfeldig tall fra 0 til k
            bytt(a,k,i);                        // bytter om
        }
        return a;                               // permutasjonen returneres
    }

    // Oppgave 1

    //hentet hjelp fra: https://stackoverflow.com/questions/34745203/using-a-for-loop-to-manually-sort-an-array-java
    public static int maks(int[] a){
        if(a.length == 0){
            throw new NoSuchElementException("Listen er tom!");
        }
        int maksVerdi = a[0];
        System.out.println("Usortert liste: " + Arrays.toString(a));
        for(int i = 0; i < a.length; i++){
            for(int j = i+1; j < a.length; j++){
                if(a[i] > a[j]){
                    int midlertidig = a[i];  //setter den største verdien "til side"
                    a[i] = a[j];             //tilegner plassen med tallet som er minst
                    a[j] = midlertidig;      //setter inn igjen den største verdien en plass frem
                    maksVerdi = a[j];
                }
            }
        }
        System.out.println("Sortert liste: " + Arrays.toString(a));
        return maksVerdi;
    }

    //Oppgave 1
    //metode som teller hvor mange ganger en ombytting skjer - skal regne ut gjennomsnittet
    public static int ombyttinger(int[] a){
        int ombytting = 0;
        int maksVerdi = a[0];
        for(int i = 1; i < a.length; i++){
            int nesteTalliRekken = a[i];  //for å unngå unødvendig mange operasjoner
            if(maksVerdi <= nesteTalliRekken){
                maksVerdi = a[i];
                ombytting++;
            }
        }
        return ombytting;
    }

    // Oppgave 2


    // Oppgave 2 - ikke kjørt testene på denne
    public static int antallUlikeSortert(int[] a){
        boolean sortert = true;
        for(int i = 0; i < a.length; i++){
            if(a[i] < a[i-1]){
                sortert = false;
            }
        }
        if(!sortert){
            throw new IllegalStateException("Tabellen er ikke sortert stigende!");
        }

        int antallUlike = 1;
        if(a.length == 0){
            antallUlike = 0;
        }
        for(int i = 1; i < a.length; i++){
            if(a[i] != a[i-1]){
                antallUlike++;
            }
        }
        return antallUlike;
    }

    //Oppgave 3 - Denne er ok nå, hehe
    public static int antallUlikeUsortert(int[] a){
        int antall = 1;
        int nyttTall;
        boolean unik = false;
        if(a.length<1){
            return 0;
        }
        for(int i = 1; i<a.length; i++){        //går gjennom arrayet og sjekker om tallet har vært tidl
            nyttTall = a[i];                    //variabelen som sjekkes om har vært tidligere
            for(int j = i+1; j<a.length; j++) {
                int telteTall = a[j];
                if(nyttTall != telteTall && nyttTall!= a[0]){
                    unik=true;
                } else {
                    unik=false;
                    break;
                }
            }
            if(unik){
                antall++;
            }
        }
        return antall;
    }

    // Oppgave 4
    //https://www.geeksforgeeks.org/sort-even-numbers-ascending-order-sort-odd-numbers-descending-order/
    public static void delsortering(int[] a){
        if(a == null){
            throw new NullPointerException("Listen er null."); //kaster exception dersom listen er null.
        }
        if(a.length == 0){
            throw new NoSuchElementException("Listen er tom!"); //kaster exception dersom listen er tom.
        }

        //går først gjennom array og finner oddetall. Setter oddetall til negative tall, så de
        //kommer helt til venstre i tabellen.
        for(int i = 0; i < a.length; i++){
            if((a[i] % 2) != 0){
                a[i] *= -1;
            }
        }
        //sorterer array i stigende rekkefølge.
        Arrays.sort(a);

        //går gjennom array på nytt og gjør oddetallene til positive tall igjen.
        for(int i = 0; i < a.length; i++){
            if((a[i] % 2) != 0){
                a[i] *= -1;
            }
        }
    }


    // Oppgave 5 - ikke kjørt testene på denne
    public static void rotasjon(char[] a){
        if(a.length == 0){
            return;
        }
        else{
            char temp = a[a.length-1];
            for(int i  = a.length-1; i > 0; i--){
                a[i] = a[i-1];
            }
            a[0] = temp;
        }
    }


    // Oppgave 6 - ikke kjørt testene på denne
    public static void rotasjon(char[] a, int k){
        if(k < 0){
            k += a.length;
        }
        for(int i = 0; i < k; i++){
            char temp = a[a.length-1];
            for(int j  = a.length-1; j > 0; j--){
                a[j] = a[j-1];
            }
            a[0] = temp;
        }
    }

    // Oppgave 7


    // Oppgave 8 - Denne fungerer ikke om det er like tall i tabellen, men skjønner ikke hvorfor???
    public static int[] indekssortering(int[] a) {
        int[] indeksTabell = new int[a.length];
        int[] sortedArray = Arrays.copyOf(a, a.length);
        Arrays.sort(sortedArray);       //hjelpetabell som er sortert i stigende rekkefølge

        if (a.length < 1) {
            return null;
        } else {                        // hvis arrayet er tomt returneres null
            for (int i = 0; i < a.length; i++) {           // løkke der vi tildeler indeksTabell[i] en verdi
                for (int j = 0; j < a.length; j++) {       // løkke der vi sjekker gjennom arrayet om vi finner riktig verdi (sammenligner sortedArray med a, finner lik verdi)
                    if (sortedArray[i] == a[j]) {        // finner neste tall i sorted array i a, som er neste indeks i indeksTabell

                        // når den har funnet en lik må vi sjekke om denne indeksen allerede ligger i indeksTabell.
                        // hvis den allerede ligger der må metoden lete etter neste forekomst istedenfor å legge til indeksen i tabellen.
                        // men dette får ikke jeg til


                        // denne if-setningen får array med opptil 2 like tall til å bli riktig, me må finne en permanent løsning
                        if (i > 0 && sortedArray[i] == sortedArray[i - 1]) {
                            break;
                        }

                        indeksTabell[i] = j;        // legger til indeksen til tallet som er funnet i indeksTabell.

                    }
                }
            }
            return indeksTabell;
        }
    }

    // Oppgave 9 - OK
    public static  int[] tredjeMin(int[] a) {
        if (a.length < 3) {
            throw new NoSuchElementException("Det er mindre enn tre elementer i a, antall: " + a.length);
        } else {
            int[] sokeTabell = {a[0], a[1], a[2]}; //lager en ny tabell med kun de tre første tallene fra a

            int m = Objects.requireNonNull(indekssortering(sokeTabell))[0]; // minsteverdi sin index
            int nm = Objects.requireNonNull(indekssortering(sokeTabell))[1]; // nest minste verdi sin indeks
            int nnm = Objects.requireNonNull(indekssortering(sokeTabell))[2];// nest nest minste verdi sin indeks

            if (a[2] < a[0]) {
                m = 2;
                nnm = 0;
            }
            if (a[2] < a[1]) {
                nm = 2;
                nnm = 1;
            }
            if (a[1] < a[0]) {
                m = 1;
                nm = 0;
            }

            int minverdi = a[m];                // minste verdi
            int nestminverdi = a[nm];           // nest minste verdi
            int nestnestminverdi = a[nnm];      // nest nest minste verdi


            for (int i = 3; i < a.length; i++) {
                if (a[i] < nestnestminverdi) {
                    if (a[i] < nestminverdi) {
                        if (a[i] < minverdi) {  // hvis neste verdi er mindre enn minste verdi
                            nnm = nm;
                            nestnestminverdi = nestminverdi; // ny nest nest størst

                            nm = m;
                            nestminverdi = minverdi;     // ny nest størst

                            m = i;
                            minverdi = a[m];              // ny størst
                        }
                        else {  // hvis neste tall er < nestminste men ikke mindre enn minste
                            nnm = nm;
                            nestnestminverdi = nestminverdi; // ny nest nest størst

                            nm = i;
                            nestminverdi = a[nm];         // ny nest størst

                        }
                    } else {
                        nnm = i;
                        nestnestminverdi = a[nnm];
                    }
                }
            }

            // n i posisjon 0, nm i posisjon 1, nnm i posisjon 2
            sokeTabell[0] = m;
            sokeTabell[1] = nm;
            sokeTabell[2] = nnm;

            return sokeTabell;
        }
    }

    // Oppgave 10
    public static boolean inneholdt(String a, String b){
        boolean inneholder = false;

        if(b.contentEquals(a) || a.isEmpty()){
            inneholder = true;
        }
        else {


            //hvis bokstavene i A er i B returneres true. ellers false.


            // gjøre om bokstavene til et heltall

            int A = 1; // er det dette han mener?
        }

        return inneholder;
    }
    // main-metode for testing, slettes før innlevering
    public static void main(String[] args) {
        int[] tomtArray = {};
        int[] array1 = randPerm(10);
        int[] array9 = {-1, 5, 0, 4, 2, 7, -1, -8, -2, 4};
        int[] array10 = {2,5,7,8,3,6,8,9,6,8};

        System.out.println("Opprinnelig array: " + Arrays.toString(array9));
        System.out.println("Oppgave 9, output: " + Arrays.toString(tredjeMin(array9)));


        //Oblig1.maks(tomtArray);
        System.out.println("OPPGAVE 1");
        System.out.println("Det største tallet i listen: "+Oblig1.maks(array9));

        System.out.println("OPPGAVE 1");
        System.out.println("Det tok " + ombyttinger(array9) + " ombyttinger å flytte det største tallet bakerst.");

        System.out.println("OPPGAVE 4");
        Oblig1.delsortering(array10);
        System.out.println(Arrays.toString(array10));

        int[] likeTallArray = {5, 5, 5, 5, 5, 5};
        int[] minusTallArray = {-1,-2,-3,-1,-7,-1000};
        int[] randomArray = randPerm(10);
        String a = "ABCA";
        String b = "ALBLCLAJA";

        /*System.out.println("Opgpave 8: " + antallUlikeUsortert(minusTallArray));*/

        //Kjører metoden i oppgave 5:
        System.out.println("OPPGAVE 5");
        char[] c = {'A','B','C','D','E', 'F','G','H','I','J'};
        char[] d = {'A'};
        char[] e = {};
        System.out.println(Arrays.toString(c));
        /*rotasjon(e);*/
        rotasjon(c, -4);
        System.out.println(Arrays.toString(c));

    }
}
