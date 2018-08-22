import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Example extends JFrame implements ActionListener
{
    private JButton btn;

    public Example()
    {
        super("Simple GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btn = new JButton("Open the other JFrame!");
        btn.addActionListener(this);
        btn.setActionCommand("Open");
        add(btn);
        pack();

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String cmd = e.getActionCommand();

        if(cmd.equals("Open"))
        {
            dispose();
            JFrame frame = new JFrame();
            frame.add(new JLabel("Hi"));
            JFXPanel jfxPanel = new JFXPanel();
            frame.add(jfxPanel, BorderLayout.NORTH);
            frame.setPreferredSize(new Dimension(800, 600));
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    Graph graph = new Graph();
                    Scene scene = new Scene(graph.getChart());
                    jfxPanel.setScene(scene);
                }
            });
            JFXPanel fxContainerTwo = new JFXPanel();
            Button btn = new Button();
            btn.setLabel("Hihihihihi");
            fxContainerTwo.add(btn);

            frame.add(fxContainerTwo, BorderLayout.SOUTH);

            frame.pack();
            frame.setVisible(true);
        }
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run()
            {
                new Example().setVisible(true);
            }

        });
    }
}