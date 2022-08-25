package stgroup;

import java.util.*;

public class Marks {
    private final Map<String, Integer> marks = new HashMap<>();

    Map<String, Integer> getMarks(){
        return marks;
    }

    //проверяет корректность получаемой оценки
    private boolean CheckCorrectMark(Integer mark){
        return !((mark == null) | !(mark >= 2 && mark <= 5));
    }

    //конструктор (предметы/ничего)
    public Marks (Set<String> subjects){
        for (String subjectName : subjects){
            if (subjectName != null){
                this.marks.put(subjectName, null);
            }
        }
    }

    //удаление оценки
    boolean deleteMark(String nameOfSubject){
        if (marks.get(nameOfSubject) != null){
            marks.put(nameOfSubject, null);
            return true;
        }
        return false;
    }

    //добавление оценки
    boolean addMark(String nameOfSubject, Integer mark){
        if (CheckCorrectMark(mark)){
            if (marks.get(nameOfSubject) == null){
                marks.put(nameOfSubject, mark);
                return true;
            }
        }
        return false;
    }

    //изменить оценку
    boolean changeMark(String nameOfSubject, Integer mark){
        if (CheckCorrectMark(mark)){
            if (marks.get(nameOfSubject) != null){
                marks.put(nameOfSubject, mark);
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Marks marks1 = (Marks) o;

        return Objects.equals(marks, marks1.marks);
    }

    @Override
    public int hashCode() {
        return marks.hashCode();
    }
}