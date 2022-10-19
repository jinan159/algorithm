package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Name {
    String fullName;
    String firstName;
    String middleName;
    String lastName;
    String fullEmail;
    
    public static Name parseName(String fullName) {
        Name name = new Name();

        name.fullName = fullName;
        
        String[] dividedName = fullName.split(" ");

        name.firstName = dividedName[0];

        if (dividedName.length == 3) {
            name.middleName = dividedName[1];
            name.lastName = dividedName[2];
        } else {
            name.lastName = dividedName[1];
        }
        
        return name;
    }

    public String convertToEmailId() {
        String email = "";
        email += this.firstName.substring(0, 1).toLowerCase();

        if (middleName != null) {
            email += this.middleName.substring(0, 1).toLowerCase();
        }

        if (this.lastName.length() > 8) {
            email += this.lastName.replaceAll("-", "")
                .substring(0, 8)
                .toLowerCase();
        } else {
            email += this.lastName.replaceAll("-", "")
                .toLowerCase();
        }

        return email;
    }
}

public class Solution1 {

    public String solution(String S, String C) {
        final String COMPANY_EMAIL = C.toLowerCase() + ".com";

        String[] nameArray = S.split(", ");

        List<Name> names = new ArrayList<>();

        // O(N)
        for (String fullName : nameArray) {
            names.add(Name.parseName(fullName));
        }

        Set<String> emailSet = new HashSet<>();

        // O(N)
        for (Name name : names) {
            String emailId = name.convertToEmailId();
            String email = getNotDuplicatedEmail(emailSet, emailId);
            emailSet.add(email);
            name.fullEmail = email + "@" + COMPANY_EMAIL;
        }

        StringBuilder sb = new StringBuilder();

        // O(N)
        for (int i = 0; i < names.size(); i++) {
            Name name = names.get(i);
            sb.append(String.format("%s <%s>", name.fullName, name.fullEmail));

            if (i < names.size() - 1) sb.append(", ");
        }

        return sb.toString();
    }

    private String getNotDuplicatedEmail(Set<String> emailSet, String email) {
        int i = 2;
        String notDuplicatedEmail = email;

        while (emailSet.contains(notDuplicatedEmail)) {
            notDuplicatedEmail = email + i;
            i++;
        }

        return notDuplicatedEmail;
    }
}
