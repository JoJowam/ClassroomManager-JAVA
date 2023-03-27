/**
 * @file Main.java
 * @brief Arquivo principal do sistema de gestão de salas de aula
 * @autor Josué Villa Real (vilareal.on@gmail.com)
 * @date 27/03/2023
 * @using JDK 19, SWING, IntelliJ IDEA Community Edition 2022.3.3
 */

import javax.swing.*;

public class Main {
    /* O Codigo abaixo dentro do método main cria a janela do menu em uma thread separada
    * do EDT "Event Dispach Thread" que resumidamente é a responsavel por processar os eventos
    * de interface do usuario. Com essa implementação a interface do usuario fica mais reponsiva e
    * confiavél para lidar com os dados dos usuarios. */

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }
}