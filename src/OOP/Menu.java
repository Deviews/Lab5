package OOP;


import java.io.IOException;
import java.util.Scanner;

class Menu {

    private void StartMenu() {
            System.out.println("    Меню:   ");
            System.out.println(" 1. Добавить элемент");
            System.out.println(" 2. Обновить элемент");
            System.out.println(" 3. Удалить элемент");
            System.out.println(" 4. Вывести элементы");
            System.out.println(" 5. Сохранить в файл");
            System.out.println(" 6. Загрузить файла");
            System.out.println(" 7. Сортировать элементы");
            System.out.println(" 8. Суммирование по ширине элементов");
            System.out.println(" 9. Выход");
    }

    void MenuSwitch() throws IOException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in);
        Factory f = new Factory();

        ArrayContainer<Art> ArtArrayContainer = new ArrayContainer<>();

        while (true) {
            StartMenu();

            int MenuKey;
            MenuKey = scan.nextInt();

            switch (MenuKey) {
                case 1: {
                    System.out.println(" Выберите объект искусства");
                    System.out.println(" 1. Картина");
                    System.out.println(" 2. Скульптура");
                    int AddKey = scan.nextInt();
                    if (AddKey == 1) {
                        System.out.println(" Введите ширину картины ");
                        double width = scan.nextDouble();
                        System.out.println(" Введите высоту картины ");
                        double heigth = scan.nextDouble();
                        System.out.println(" Выберите тип краски");
                        System.out.println(" 1. ACRYLIC");
                        System.out.println(" 2. OIL");
                        System.out.println(" 3. WATER");
                        int code = scan.nextInt();
                        ArtArrayContainer.add(f.createPainting(width, heigth, PaintType.valueOf(code)));

                    } else if (AddKey == 2) {
                        System.out.println(" Введите ширину скульптуры ");
                        double width = scan.nextDouble();
                        System.out.println(" Введите высоту скульптуры ");
                        double heigth = scan.nextDouble();
                        System.out.println(" Введите длинну скульптуры ");
                        double length = scan.nextDouble();
                        System.out.println(" Выберите тип материала");
                        System.out.println(" 1. MARBLE");
                        System.out.println(" 2. IRON");
                        System.out.println(" 3. STONE");
                        int code = scan.nextInt();
                        ArtArrayContainer.add(f.createSculpture(width, heigth, length, Material.valueOf(code)));
                    } else {
                        System.out.println();
                    }
                    break;
                }
                case 2: {
                    if (ArtArrayContainer.getCount() == 0) {
                        System.out.println("Массив не содержит элементов");
                    } else {
                        System.out.println("Введите номер элемента");
                        int index = scan.nextInt();
                        ArtArrayContainer.update(index);
                    }
                    break;
                }
                case 3: {

                    if (ArtArrayContainer.getCount() == 0) {
                        System.out.println("Массив не содержит элементов");
                    } else {
                        System.out.println("Введите номер удаляемого элемента ");
                        int index = scan.nextInt();
                        ArtArrayContainer.delete(index);
                    }
                    break;
                }
                case 4: {
                    ArtArrayContainer.printAll();
                    break;
                }
                case 5: {
                    ArtArrayContainer.upload();
                    break;
                }
                case 6: {
                    ArtArrayContainer.load();
                    break;
                }
                case 7: {

                    System.out.println(" 1. Сортировать по ширине");
                    System.out.println(" 2. Сортировать по высоте");
                    int SortKey = scan.nextInt();
                    if (SortKey == 1) {
                        ArtArrayContainer.SortByWidth();
                    } else if (SortKey == 2) {
                        ArtArrayContainer.SortByHeigth();
                    }
                    break;
                }
                case 8: {
                    System.out.println("Сумма элементов по ширине=" + ArtArrayContainer.SumWidth());
                    break;
                }
                case 9: {
                    return;
                }
            }
        }
    }
}

