/**
 * UFCG - Universidade Federal de Campina Grande
 * LP2 - Laboratorio de Programacao 2 - Projeto Final
 * Caio Vitor Brasileiro Torres - 116111245
 * Francivaldo Cabral de Andrade - 116111544
 * Luan Carlos da Silva Bezerra - 116110100
 */
package modelos.aluno;
import java.util.Comparator;
/**
 * Classe MatriculaComparator, implementa a forma de comparacao para o Aluno com base na matricula
 * @author Caio Torres
 * @version 1.1
 */
public class MatriculaComparator implements Comparator<Aluno> {
    
    @Override
    public int compare(Aluno aluno, Aluno outroAluno) {
        return aluno.getMatricula().compareTo(outroAluno.getMatricula());
    }
}
