import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        String movementList = "src/main/resources/movementList.csv";

        try {
            List<String> lines = Files.readAllLines(Paths.get(movementList));

            statement(lines);
            totalValue(lines);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void statement(List<String> lines)
    {
        System.out.println("Выписка расходов:\n");
        for (int i = 1; i < lines.size(); i++){
            String[] frag = lines.get(i).split(",");
            String[] operation = frag[5].replaceAll("[0-9]|\\.|\\+","").split("[\\\\]");
            if (frag.length == 8){
                if(Integer.parseInt(frag[7]) != 0){
                    if(operation.length == 5) {
                        String[] nameOperation = operation[4].split(" ");
                        System.out.println(nameOperation[0] + " " + nameOperation[1] + " - " + frag[7] + " рублей");
                    }
                    if(operation.length == 4) {
                        String[] nameOperation = operation[3].split(" ");
                        System.out.println(nameOperation[0] + " " +  nameOperation[1] + " - " + frag[7] + " рублей");
                    }
                }
            }
            if (frag.length == 9){
                String value = frag[7] + "." + frag[8];
                double sum = Double.parseDouble(value.replace("\"",""));

                if(operation.length == 5) {
                    String[] nameOperation = operation[4].split(" ");
                    System.out.println(nameOperation[0] + " " + nameOperation[1] + " - " + sum + " рублей");
                }
                if(operation.length == 4) {
                    String[] nameOperation = operation[3].split(" ");
                    System.out.println(nameOperation[0] + " " +  nameOperation[1] + " - " + sum + " рублей");
                }
            }
        }
    }

    public static void totalValue(List<String> lines)
    {
        int totalIncome = 0;
        int totalOutcome = 0;

        for (int i = 1; i < lines.size(); i++){
            String[] frag = lines.get(i).split(",");

            if (frag.length == 8){
                if(Integer.parseInt(frag[7]) != 0){
                    totalOutcome += Integer.parseInt(frag[7]);
                }
                if(Integer.parseInt(frag[6]) != 0){
                    totalIncome += Integer.parseInt(frag[6]);
                }
            }
            if (frag.length == 9){
                String value = frag[7] + "." + frag[8];
                double sum = Double.parseDouble(value.replace("\"",""));
                totalOutcome += sum;
            }
        }
        System.out.println("\nОбщий расход: " + totalOutcome);
        System.out.println("Общий доход: " + totalIncome);
    }
}
