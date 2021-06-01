package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0D);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(pupil -> new Tuple(pupil.getName(),
                pupil.getSubjects()
                .stream()
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0)))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return  stream
                .flatMap(pupil -> pupil
                        .getSubjects()
                        .stream())
                .collect(Collectors.groupingBy(Pupil::getSubjects,
                        Collectors.averagingDouble(Subject::getScore)))????????????

                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(pupil -> new Tuple(pupil.getName(),
                pupil.getSubjects()
                        .stream()
                        .mapToInt(Subject::getScore)
                        .sum()
                        .orElse(0)
                .max(Comparator.comparing(new Tuple(pupil.getName(), ?????????????))));
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return  stream
                .flatMap(pupil -> pupil
                        .getSubjects()
                        .stream())
                .collect(Collectors.groupingBy(Pupil::getSubjects,
                        Collectors.summingDouble(Subject::getScore)))????????????
                                .orElse(0)
                .max(Comparator.comparing(new Tuple(pupil.getName(), ?????????????)));
    }
}