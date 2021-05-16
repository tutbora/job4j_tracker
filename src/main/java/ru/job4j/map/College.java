package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class College {
    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccountOpti(String account) {
        return students.keySet()
                .stream()
                .filter(s -> account.equals(s.getAccount()))
                .findFirst();
    }

    public Optional<Subject> findBySubjectNameOpti(String account, String name) {
        Optional<Subject> rsl = Optional.empty();
        var s = findByAccountOpti(account);
        if (s.isPresent()) {
            var subjects = students.get(s.get());
            rsl = subjects.stream()
                    .filter(subj -> name.equals(subj.getName()))
                    .findFirst()
                    .map(Optional::of)
                    .orElse(rsl);
        }
        return rsl;
    }
}