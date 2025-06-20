package catcafe;

import tree.InOrderVisitor;
import tree.PostOrderVisitor;

/** Starter for the cat-café task. */
public class Main {
    /**
     * And go.
     *
     * @param args command line parameters, not used
     */
    public static void main(String... args) {
        CatCafe cafe = new CatCafe();

        cafe.addCat(new FelineOverLord("Miss Chief Sooky", 2));
        cafe.addCat(new FelineOverLord("Gwenapurr Esmeralda", 3));
        cafe.addCat(new FelineOverLord("Morticia", 3));
        cafe.addCat(new FelineOverLord("Fitzby Darnsworth", 5));

        System.out.println("Es schnurren " + cafe.getCatCount() + " Samtpfötchen.");

        // Visitor Pattern Demo
        System.out.println("\n=== Visitor Pattern Demo ===");
        InOrderVisitor<FelineOverLord> inOrderVisitor = new InOrderVisitor<>();
        PostOrderVisitor<FelineOverLord> postOrderVisitor = new PostOrderVisitor<>();

        System.out.println("InOrder: " + cafe.accept(inOrderVisitor));
        System.out.println("PostOrder: " + cafe.accept(postOrderVisitor));


        // Suche nach einer Katze mit Gewicht zwischen 3 (inklusive) und 4 (exklusive)
        cafe.getCatByWeight(3, 4).ifPresent(meow -> System.out.println("Gewicht [3,4]: " + meow));
        // ifPresent() führt den Code nur aus, wenn eine Katze gefunden wird
        // meow ist die gefundene Katze

        // Suche nach einer Katze mit dem Namen "Morticia"
        cafe.getCatByName("Morticia")
                .ifPresent(meow -> System.out.println("Name 'Morticia': " + meow));
        // Gibt die erste Katze mit diesem Namen aus, falls vorhanden

        // Suche nach einer Katze mit dem Namen "Miss Chief Sooky"
        cafe.getCatByName("Miss Chief Sooky")
                .ifPresent(meow -> System.out.println("Name 'Miss Chief Sooky': " + meow));
        // Gibt diese spezielle Katze aus, falls sie im Café ist
    }
}
