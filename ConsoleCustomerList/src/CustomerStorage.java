import java.util.HashMap;

public class CustomerStorage
{

    private static final String EXAMPLE_EMAIL_1 = "@gmail.com";
    private static final String EXAMPLE_EMAIL_2 = "@mail.ru";
    private static final String EXAMPLE_EMAIL_3 = "@rambler.ru";
    private static final String EXAMPLE_PHONE_1 = "+79";
    private static final String EXAMPLE_PHONE_2 = "89";
    private HashMap<String, Customer> storage;

    public CustomerStorage()
    {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws ArrayIndexOutOfBoundsException,IllegalAddCommandException
    {
        String[] components = data.split("\\s+");
        String name = components[0] + " " + components[1];
        if (!components[2].contains(EXAMPLE_EMAIL_1)){
            if (!components[2].contains(EXAMPLE_EMAIL_2)){
                if (!components[2].contains(EXAMPLE_EMAIL_3)){
                    throw new IllegalAddCommandException("Illegal Email format");
                }
            }
        }
        if (!components[3].contains(EXAMPLE_PHONE_1)){
            if (!components[3].contains(EXAMPLE_PHONE_2)){
                throw new IllegalAddCommandException("Illegal phoneNumber format");
            }
        }

        storage.put(name, new Customer(name, components[3], components[2]));
    }

    public void listCustomers()
    {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name)
    {
        storage.remove(name);
    }

    public int getCount()
    {
        return storage.size();
    }
}