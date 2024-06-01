import java.time.LocalDate;

public class Client {

    private final BankAccount account;
    private final String firstName;
    private final String familyName;

    private final Phone phone;

    private final String email;
    private final LocalDate dateOfBirth;

    public Client(BankAccount account,
                  String firstName,
                  String familyName,
                  Phone phone,
                  String email,
                  LocalDate dateOfBirth) {
        this.account = account;
        this.firstName = firstName;
        this.familyName = familyName;
        this.phone = phone;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }
}
