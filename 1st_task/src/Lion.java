public class Lion {
    private boolean hungry = true;

    public void inputOfGoods(String inputSymbol) {
        inputSymbol = inputSymbol.toLowerCase();
        if (inputSymbol.equals("антилопа")) {
            if (hungry) {
                System.out.println("Антилопа съедена, лев будет сыт");
                hungry = false;
            } else {
                System.out.println("Лев спит");
                hungry = true;
            }
        } else if (inputSymbol.equals("охотник")) {
            if (hungry) {
                System.out.println("Лев убежал");
            } else {
                System.out.println("Лев убежал");
                hungry = true;
            }
        } else if (inputSymbol.equals("дерево")) {
            if (hungry) {
                System.out.println("Лев спит");
            } else {
                System.out.println("Лев смотрит на дерево");
                hungry = true;
            }
        } else {
            System.err.println(String.format("Неизвестная строка, %s", inputSymbol));
        }
    }
}
