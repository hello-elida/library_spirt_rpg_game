package br.edu.ifmg.libraryspirit.boss;

import br.edu.ifmg.libraryspirit.characters.Threat;
import br.edu.ifmg.libraryspirit.items.Theme;

import java.util.List;

public class SealingStage {
    /** Guarda o número da rodada atual do comfronto final.*/
    private int currentRound = 1;
    /** Guarda o tema da etapa.*/
    private  Theme theme;
    /** Guarda a lista de ameaças d etapa.*/
    private List<Threat> threats;
    /** Guarda o nome da pagina.*/
    private String requiredPage;

    public SealingStage(Theme theme,List<Threat> threats, String requiredPage){
        this.theme = theme;
        this.threats =threats;
        this.requiredPage = requiredPage;
    }

    /**
     * Retorna o tema desta etapa.
     *
     * @return tema da etapa
     */
    public Theme getTheme() {
        return theme;
    }

    /**
     * Retorna o número da rodada atual do chefe final.
     *
     * @return número da rodada atual
     */
    public int getCurrentRound() {
        return currentRound;
    }

    /** Avança a rodada do chefe final em uma unidade
     *  sem ultrpassar a terceira rodada.
     *  */

    public void AdvanceRounds() {
        if(currentRound < 3) {
            currentRound++;
        }
    }

    public void resetRounds () {
        currentRound = 1;

        }
    /**
     * Retorna as três ameaças desta etapa.
     *
     * @return lista de ameaças da etapa
     */
    public List<Threat> getThreats() {
        return threats;
    }

}
