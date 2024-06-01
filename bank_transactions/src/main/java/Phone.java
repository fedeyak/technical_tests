
import java.util.Set;
import java.util.TreeSet;

public class Phone {
    private static final int MIN_PHONES_AMOUNT = 1;
    private final Set<String> phones;

    public Phone() {
        phones = new TreeSet<String>();
    }

    public Phone(String phone) {
        phones = new TreeSet<String>();
        if (checkPhoneNumber(phone)) {
            phones.add(phone);
        } else {
            System.out.println("Wrong phone format. Please retry.");
        }
    }

    public void addPhone(String phone){
        phones.add(phone);
    }
    public void deletePhone(String phone) {
        if (phones.size() > MIN_PHONES_AMOUNT) {
            phones.remove(phone);
        }
        System.out.println("Add a new phone number before deleting the current one.");
    }

    public void changePhone(String previousPhone, String newPhone){
        deletePhone(previousPhone);
        addPhone(newPhone);
    }

    private boolean checkPhoneNumber(String phone) {
        return PhoneNumberChecker.checkPhoneNumber(phone);
    }
}
