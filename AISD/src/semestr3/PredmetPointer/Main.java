package semestr3.PredmetPointer;
import java.util.*;

public class Main {
    static ArrayList<Termin> termins = new ArrayList<Termin>();
    static Scanner in = new Scanner(System.in);
    static boolean fl = false;
    static boolean checkFind = false;
    static int level;
    static String[] root;
    static String tab = "  ";

    public static void main(String[] args){
        Initialize();
        System.out.format("%40s", "ПРЕДМЕТНЫЙ УКАЗАТЕЛЬ\n");
        int i;
        do {
            System.out.println("Выберите действие: ");
            System.out.println("1 : Вывести список.");
            System.out.println("2 : Добавить термин в список.");
            System.out.println("3 : Найти термин в списке.");
            System.out.println("4 : Отсортировать список.");
            System.out.println("5 : Удалить термин из списка.");
            System.out.println("6 : Изменить термин в списке.");
            System.out.println("7 : Выйти.");
            i = in.nextInt();
            switch (i) {
                case 1: Output();
                    break;
                case 2: Add();
                    break;
                case 3: Find();
                    break;
                case 4: {
                    System.out.println("Изначальный список:\n");
                    Output();
                    Sort();
                    System.out.println("Список после сортировки: ");
                    System.out.println();
                    Output();
                }

                break;
                case 5: {
                    in.nextLine();
                    DeleteChange(1);
                }
                    break;
                case 6:{
                    in.nextLine();
                    DeleteChange(2);
                }
                    break;
            }
            System.out.println();
        } while(i!=7);

    }


    public static void AddTerm(ArrayList<Termin> term, int j){
        for (Termin termin : term) {
            if (j < root.length) {
                if (j == root.length - 1) {
                    if (termin.name.equals(root[j])) {
                        String name;
                        boolean check = false;
                        do {
                            System.out.println("Введите название нового термина: ");
                            name = in.nextLine();
                            boolean is = true;
                            if (Arrays.binarySearch(root,name)<0){
                                is = false;
                                for (int l=0; l<termin.podtermins.size(); l++){
                                    if (termin.podtermins.get(l).name.equals(name)) {
                                        is = true;
                                        break;
                                    }
                                }
                            }
                            if (!is) check = true;

                        }while(!check);
                        System.out.println("Введите количество страниц: ");
                        int kol = in.nextInt();
                        int[] pages = new int[kol];
                        System.out.println("Введите номера страниц через пробел: ");
                        for (int i=0; i<kol; i++){
                            pages[i] = in.nextInt();
                        }
                        termin.podtermins.add(new Termin(name, pages));
                        fl=true;
                        break;
                    }
                } else if (termin.name.equals(root[j])) {
                    AddTerm(termin.podtermins, j + 1);
                }
            }

        }
    }


    public static void Add(){

        System.out.println("Введите 1 для добавления термина. Введите 2 для добавления подтермина:");
        int koef = in.nextInt();
        in.nextLine();
        if (koef==1){
            boolean check = true;
            String name;
            do {
                check = false;
                System.out.println("Введите название нового термина: ");
                name = in.nextLine();
                for (int i=0; i< termins.size(); i++){
                    if (termins.get(i).name.equals(name)) {
                        check = true;
                        break;
                    }
                }
            }while(check);

            System.out.println("Введите количество страниц:");
            int kol = in.nextInt();
            int[] pages = new int[kol];
            System.out.println("Введите номера страниц через пробел: ");
            for (int i=0; i<kol; i++){
                pages[i] = in.nextInt();
            }
            termins.add(new Termin(name, pages));
        }
        else {
            if (koef==2){

                System.out.println("Введите путь в который хотите добавить :");
                String put = in.nextLine();
                root = put.split("-");

                AddTerm(termins,0);
                if (!fl) System.out.println("Нет такого пути.\n");
                root = null;
                fl = false;
            }
            else System.out.println("Некорректный ввод.");
        }

    }

    public static void DeleteChangeTerm(ArrayList<Termin> term, int j, int koef){
        for (Termin termin : term) {
            if (j < root.length) {
                if (j == root.length - 1) {
                    if (termin.name.equals(root[j])) {
                        if (koef==1) term.remove(termin);
                        else{
                            String name;
                            boolean check = false;
                            do {
                                System.out.println("Введите новое название термина: ");
                                name = in.nextLine();
                                boolean is = true;
                                if (Arrays.binarySearch(root,name)<0){
                                    is = false;
                                    for (int l=0; l<term.size(); l++){
                                        if (term.get(l).name.equals(name)) {
                                            is = true;
                                            break;
                                        }
                                    }
                                }
                                if (!is) check = true;
                            }while(!check);

                            termin.name = name;

                            System.out.println("Введите количество страниц:  ");
                            int kol = in.nextInt();
                            int[] pages = new int[kol];
                            System.out.println("Введите номера страниц через пробел: ");
                            for (int i=0; i<kol; i++){
                                pages[i] = in.nextInt();
                            }
                            termin.pages = Arrays.copyOf(pages,pages.length);
                        }

                        fl=true;
                        break;
                    }
                } else if (termin.name.equals(root[j])) {
                    DeleteChangeTerm(termin.podtermins, j + 1, koef);
                }
            }

        }
    }

    public static void DeleteChange(int koef){
        if (koef==1) System.out.println("Введите путь термина для удаления: ");
        else System.out.println("Введите путь термина для изменения: ");
        String put = in.nextLine();
        root = put.split("-");
        DeleteChangeTerm(termins,0, koef);
        if (!fl) System.out.println("Нет такого пути.\n");
        root = null;
        fl = false;

    }

    public static void SortingName(ArrayList<Termin> term){
        for (int j = 1; j < term.size(); j++) {
            for (int k = j; k > 0; k--) {
                if(term.get(k).name.compareTo(term.get(k-1).name) < 0){
                    Termin temp2 =term.get(k);
                    term.set(k,term.get(k-1));
                    term.set(k-1,temp2);
                }else{
                    break;
                }
            }
        }
    }

    public static void SortingPages(ArrayList<Termin> term){
        for (int i=0; i<term.size(); i++){
            Arrays.sort(term.get(i).pages);
        }
        for (int j = 1; j < term.size(); j++) {
            for (int k = j; k > 0; k--) {
                if (term.get(k).pages[0] < term.get(k-1).pages[0]){
                    Termin temp2 =term.get(k);
                    term.set(k,term.get(k-1));
                    term.set(k-1,temp2);
                }else{
                    break;
                }
            }
        }
    }

    public static void SortTerm(ArrayList<Termin> term, int lev, int koef){
        for (int i=0; i< term.size(); i++){
            if (level == lev){
                if (koef==1) SortingName(term.get(i).podtermins);
                else SortingPages(term.get(i).podtermins);

            } else {
                SortTerm(term.get(i).podtermins,lev+1,koef);
            }
        }
    }

    public static void Sort() {
        System.out.println("Введите уровень вложенности для сортировки: ");
        int lev = in.nextInt();
        System.out.println("Введите 1, чтобы отсортировать по названию. Введите 2, чтобы отсортировать по минимальной странице: ");
        int koef = in.nextInt();
        if (koef==1 || koef==2) {
            if (lev == 1) {
                if (koef == 1) SortingName(termins);
                if (koef == 2) SortingPages(termins);

            } else {
                level = lev;
                SortTerm(termins, 2, koef);

            }
        }
        else System.out.println("Некорректный ввод.");
    }

    public static void  FindTerm (ArrayList<Termin> term, String name,int level){

        for (int i=0; i<term.size(); i++){
            if  (term.get(i).name.equals(name)){
                fl=true;
            }

            if (!fl) FindTerm(term.get(i).podtermins,name,level+1);
            if (level==1 && fl) {
                OutputOneTerm("",term,i);
                OutputTerm(term.get(i).podtermins, tab);
                System.out.println();
                checkFind = true;
                fl=false;

            }
        }

    }

    public static void Find(){
        System.out.println("Введите 1, чтобы найти термин по подтермину. Введите 2, чтобы найти подтермины по термину:");
        int k = in.nextInt();
        in.nextLine();
        if (k==1){

            System.out.println("Введите название подтермина:");
            String name = in.nextLine();
            FindTerm(termins,name,1);
            if (!checkFind) System.out.println("Нет такого подтермина.\n");

        }
        else {
            if (k == 2) {
                System.out.println("Введите название термина:");
                String name = in.nextLine();
                FindTerm(termins,name,1);
                if (!checkFind) System.out.println("Нет такого термина.\n");

            } else {
                System.out.println("Некорректный ввод.");
            }
        }
        fl=false;
        checkFind = false;
    }

    public static void OutputOneTerm(String tab, ArrayList<Termin> term, int i) {
        String name = tab + term.get(i).name;
        System.out.format("%1$-25s %2$50s", name,
                Arrays.toString(term.get(i).pages).substring(1).replaceFirst("]", ""));
        System.out.println(";");
    }

    public static void  OutputTerm (ArrayList<Termin> term, String tab){

        for (int i = 0; i < term.size(); i++) {
            OutputOneTerm(tab,term,i);
            if (!term.get(i).podtermins.isEmpty()) OutputTerm(term.get(i).podtermins,  tab+tab);
        }
    }

    public static void Output(){
        for (int i=0; i<termins.size(); i++){
            OutputOneTerm("",termins,i);
            OutputTerm(termins.get(i).podtermins, tab);
            System.out.println();
        }
    }

    public static void Initialize(){
        termins.add(new Termin("Пищеварительная система",new int[]{1,2,3}));
        termins.add(new Termin("Дыхательная система",new int[]{10,12}));
        termins.add(new Termin("Нервная система",new int[]{4,20,35}));
        termins.add(new Termin("Половая система",new int[]{1,46,51,65}));
        termins.add(new Termin("Покровная система",new int[]{5,34,41}));
        termins.add(new Termin("Имунная система",new int[]{6,10,11,15}));

        termins.get(0).podtermins.add(new Termin("Кишечная трубка",new int[]{2,9,13}));
        termins.get(0).podtermins.add(new Termin("Пищеварительные железы",new int[]{14,16,35,39}));

        termins.get(0).podtermins.get(0).podtermins.add(new Termin("Ротовая полость",new int[]{10,19,33,44}));
        termins.get(0).podtermins.get(0).podtermins.add(new Termin("Пищевод",new int[]{7,12,36,54}));
        termins.get(0).podtermins.get(0).podtermins.add(new Termin("Желудок",new int[]{6,23}));
        termins.get(0).podtermins.get(0).podtermins.add(new Termin("Кишечник",new int[]{7,15,99}));

        termins.get(0).podtermins.get(0).podtermins.get(3).podtermins.add(new Termin("Тонкий",new int[]{14,18,42}));
        termins.get(0).podtermins.get(0).podtermins.get(3).podtermins.add(new Termin("Толстый",new int[]{14,18,42}));

        termins.get(1).podtermins.add(new Termin("Воздушные пути",new int[]{7,23,45}));
        termins.get(1).podtermins.add(new Termin("Лёгкие",new int[]{2,24,29,46}));

        termins.get(1).podtermins.get(0).podtermins.add(new Termin("Воздушная полость",new int[]{43,101,102,104}));
        termins.get(1).podtermins.get(0).podtermins.add(new Termin("Трахея",new int[]{1,2,3}));
        termins.get(1).podtermins.get(0).podtermins.add(new Termin("Бронхи",new int[]{15,25,45,82}));

        termins.get(1).podtermins.get(0).podtermins.get(0).podtermins.add(new Termin("Носовая полость",new int[]{14,18,42}));
        termins.get(1).podtermins.get(0).podtermins.get(0).podtermins.add(new Termin("Ротовая полость",new int[]{14,18,42}));

        termins.get(2).podtermins.add(new Termin("Мозг",new int[]{1,55,86}));
        termins.get(2).podtermins.add(new Termin("Нервы",new int[]{27,68,73,75,90}));
        termins.get(2).podtermins.add(new Termin("Рецепторы",new int[]{40,64,51,87}));

        termins.get(2).podtermins.get(0).podtermins.add(new Termin("Головной",new int[]{43,30,32,104}));
        termins.get(2).podtermins.get(0).podtermins.add(new Termin("Спинной",new int[]{1,5,7}));

        termins.get(3).podtermins.add(new Termin("Половые железы",new int[]{18,26,27,35,93}));
        termins.get(3).podtermins.add(new Termin("Выводные протоки",new int[]{4,29,43}));

        termins.get(3).podtermins.get(0).podtermins.add(new Termin("Гонады",new int[]{43,30,32,104}));
        termins.get(3).podtermins.get(1).podtermins.add(new Termin("Органы",new int[]{1,5,7}));

        termins.get(3).podtermins.get(0).podtermins.get(0).podtermins.add(new Termin("Семенники",new int[]{14,18,42}));
        termins.get(3).podtermins.get(0).podtermins.get(0).podtermins.add(new Termin("Яичники",new int[]{14,18,42}));

        termins.get(4).podtermins.add(new Termin("Кожные покровы",new int[]{5,17,56}));
        termins.get(4).podtermins.add(new Termin("Кожные железы",new int[]{26,29,37,58,102}));

        termins.get(4).podtermins.get(0).podtermins.add(new Termin("Эпидермис",new int[]{43,30,32,104}));
        termins.get(4).podtermins.get(0).podtermins.add(new Termin("Дерма",new int[]{1,5,7}));
        termins.get(4).podtermins.get(0).podtermins.add(new Termin("Гиподерма",new int[]{43,30,32,104}));
        termins.get(4).podtermins.get(1).podtermins.add(new Termin("Молочные железы",new int[]{1,5,7}));
        termins.get(4).podtermins.get(1).podtermins.add(new Termin("Сальные железы",new int[]{11,15,7}));
        termins.get(4).podtermins.get(1).podtermins.add(new Termin("Потовые железы",new int[]{10,15,7}));

        termins.get(5).podtermins.add(new Termin("Органы",new int[]{1,5,7}));

        termins.get(5).podtermins.get(0).podtermins.add(new Termin("Мозг",new int[]{1,53,68}));
        termins.get(5).podtermins.get(0).podtermins.add(new Termin("Тимус",new int[]{15,20,31,59,67}));
        termins.get(5).podtermins.get(0).podtermins.add(new Termin("Лимфоузлы",new int[]{12,39,61}));
        termins.get(5).podtermins.get(0).podtermins.add(new Termin("Селезёнка",new int[]{18,19,20}));
    }

}