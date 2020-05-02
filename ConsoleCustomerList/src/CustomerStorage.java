import NotValidException.NotValidCommandException;
import NotValidException.NotValidEmailException;
import NotValidException.NotValidPhoneNumberException;

import java.util.HashMap;

public class CustomerStorage
{

    private static final String EXAMPLE_EMAIL_1 = "@gmail.com";
    private static final String EXAMPLE_EMAIL_2 = "@mail.ru";
    private static final String EXAMPLE_EMAIL_3 = "@rambler.ru";
    private static final String EXAMPLE_PHONE_1 = "+79";
    private static final String EXAMPLE_PHONE_2 = "89";
    private static final String EMAIL_EXCEPTION = "Illegal Email format\n"
            + "Available email examples:\n"
            + "\t\tvasily.petrov@gmail.com\n"
            + "\t\talexey@mail.ru\n" + "\t\tpetrov@rambler.ru";
    private static final String PHONE_NUMBER_EXCEPTION = "Illegal phoneNumber format,"
            + " phone number should start with +79 or 89.\n"
            + "\tAvailable phone number examples: +79098777812 or 89098777812";
    private static final String COMMAND_EXCEPTION = "Wrong add command format! Available command examples: \n"
            + "\tadd Василий Петров " + "vasily.petrov@gmail.com +79215637722";

    private HashMap<String, Customer> storage;

    public CustomerStorage()
    {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws IndexOutOfBoundsException, NotValidCommandException
    {
        String[] components = data.split("\\s+");
        if (components.length != 4){
            throw new IndexOutOfBoundsException(COMMAND_EXCEPTION);
        }
        String name = components[0] + " " + components[1];
        if (!components[2].contains(EXAMPLE_EMAIL_1)){
            if (!components[2].contains(EXAMPLE_EMAIL_2)){
                if (!components[2].contains(EXAMPLE_EMAIL_3)){
                    throw new NotValidEmailException(EMAIL_EXCEPTION);
                }
            }
        }
        String number = components[3].substring(0,3);
        if (!number.contains(EXAMPLE_PHONE_1)){
            if (!number.contains(EXAMPLE_PHONE_2)){
                throw new NotValidPhoneNumberException(PHONE_NUMBER_EXCEPTION);
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