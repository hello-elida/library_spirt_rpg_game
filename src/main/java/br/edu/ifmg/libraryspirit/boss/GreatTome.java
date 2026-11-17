
package br.edu.ifmg.libraryspirit.boss;

import br.edu.ifmg.libraryspirit.characters.Threat;
import br.edu.ifmg.libraryspirit.items.Theme;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa o Grande Tomo, chefe final do jogo.
 * O confronto possui três etapas:
 * Terror, Aventura e Ficção Científica.
 * Cada etapa possui três ameaças e exige
 * uma página mágica correspondente.
 */
public class GreatTome {

    /**Armazena as etapas do chefe final
     *
     */
    private List<SealingStage> stages;

    /**
     * Inicializa as três etapas do Grande Tomo.
     */
    private  int currentStageIndex = 0;

    public GreatTome() {

        /** Inicializa a lista de etapas

         */
        stages = new ArrayList<>();


        /** ETAPA 1 - TERROR
         *
         */


        /**Lista de ameaças de Terror
         *
         */
        List<Threat> horrorThreats = new ArrayList<>();

        /** Primeira ameaça
         *
         */
        horrorThreats.add(new Threat(
                "Sombras surgem entre as estantes.",
                "esconder"
        ));

        /** Segunda ameaça
         *
         */
        horrorThreats.add(new Threat(
                "Livros voam em sua direção.",
                "desviar"
        ));

        /** Terceira ameaça
         *
         */
        horrorThreats.add(new Threat(
                "Uma sombra bloqueia a passagem.",
                "pular"
        ));

        /** Cria a etapa de Terror
         *
         */
        SealingStage terrorStage = new SealingStage(
                Theme.HORROR,
                horrorThreats,
                "terror"
        );

        /** Adiciona Terror à lista de etapas
         *
         */
        stages.add(terrorStage);

        /** ETAPA 2 - AVENTURA
         * Lista de ameaças de Aventura
         */
        List<Threat> adventureThreats = new ArrayList<>();

        /** Primeira ameaça
         *
         */
        adventureThreats.add(new Threat(
                "Uma pedra gigante rola em sua direção.",
                "desviar"
        ));

        /** Segunda ameaça
         *
         */
        adventureThreats.add(new Threat(
                "Uma armadilha se abre no chão.",
                "pular"
        ));

        /** Terceira ameaça
         */
        adventureThreats.add(new Threat(
                "Uma criatura surge no caminho.",
                "esconder"
        ));

        /** Cria a etapa de Aventura
         *
         */
        SealingStage adventureStage = new SealingStage(
                Theme.ADVENTURE,
                adventureThreats,
                "aventura"
        );

        /** Adiciona Aventura à lista de etapas
         *
         */
        stages.add(adventureStage);


        /** ETAPA 3 - FICÇÃO CIENTÍFICA
         * Lista de ameaças de Ficção Científica
         */

        List<Threat> sciFiThreats = new ArrayList<>();

        /** Primeira ameaça
         */
        sciFiThreats.add(new Threat(
                "Um robô dispara um raio de energia.",
                "desviar"
        ));

        /** Segunda ameaça
         */

        sciFiThreats.add(new Threat(
                "Um drone sobrevoa o corredor.",
                "abaixar"
        ));

        /** Terceira ameaça
         *
         */
        sciFiThreats.add(new Threat(
                "Uma barreira de energia surge no caminho.",
                "pular"
        ));

        /** Cria a etapa de Ficção Científica
         *
         */
        SealingStage sciFiStage = new SealingStage(
                Theme.SCI_FI,
                sciFiThreats,
                "ficcao"
        );

        /* Adiciona Ficção Científica à lista
         *
         */
        stages.add(sciFiStage);
    }

    /**
     * Retorna as três etapas do chefe final
     * na ordem em que devem ser enfrentadas.
     * @return lista das etapas do Grande Tomo
     */
    public List<SealingStage> getStages() {
        return stages;
    }
    /**
     * Retorna a etapa atual do chefe.
     *
     * @return etapa atual ou null quando todas terminarem
     */
    public SealingStage getCurrentStage() {
        if (currentStageIndex >= stages.size()) {
            return null;
        }

        return stages.get(currentStageIndex);
    }
    /**
     * Verifica se todas as etapas do Grande Tomo terminaram.
     *
     * @return true se o chefe foi derrotado
     */
    public boolean isDefeated() {
        return currentStageIndex >= stages.size();
    }

    /**
     * Avança para a próxima etapa do chefe.
     */
    public void advanceStage() {
        SealingStage currentStage = getCurrentStage();
        if (currentStage != null && currentStage.isCompleted()) {
            currentStageIndex++;
        }
    }

    /*
     * Reinicia o chefe na primeira etapa.
     */
    public void resetStages() {
        currentStageIndex = 0;

        for (SealingStage stage : stages) {
            stage.resetRounds();
        }
    }
}