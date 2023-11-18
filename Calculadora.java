import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame {
    //añado todos los botones del formulario
    private JButton MSButton;
    private JButton mmasButton;
    private JButton mmenosButton;
    private JButton MCButton;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton dividir;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton xButton;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton resta;
    private JButton CEButton;
    private JButton a0Button;
    private JButton decimal;
    private JButton suma;
    private JTextPane display;
    private JButton porcentaje;
    private JButton cButton;
    private JButton igual;
    private JPanel mainPanel;
    //Añado variables para los operandos, la memoria, el tipo de operacion, una variable para hacer el porcentaje
    private double operando1;
    private double operando2;
    private double memoria = 0;
    private String operacion;
    private double nporcentaje;
    //Añado un boolean para poder resetear los datos que se muestran en el display
    private boolean reset = false;
    //Añado un boolean para controlar el uso del punto
    private boolean decimalused = false;
    private boolean firstry = true;

    public Calculadora() {
        //Alinear el texto del display hacia la derecha
        StyledDocument doc = display.getStyledDocument();
        SimpleAttributeSet right = new SimpleAttributeSet();
        StyleConstants.setAlignment(right, StyleConstants.ALIGN_RIGHT);
        doc.setParagraphAttributes(0, doc.getLength(), right, false);
        //Hago que se muestre el diseño hecho en el formulario
        setContentPane(mainPanel);
        //Añado título a la ventana
        setTitle("Calculadora");
        //Función del botón salir
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Tamaño
        setBounds(0, 0, 300, 250);
        //Icono
        Toolkit tl = Toolkit.getDefaultToolkit();
        Image icon = tl.getImage("src/icono.png");
        setIconImage(icon);
        //Ventana visible
        setVisible(true);

        //ActionListeners de los botones

        //Botón restar memoria
        mmenosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Creo una variable para poder restar al valor que se muestra en el display el valor almacenado en memoria (por defecto es 0)
                double restamemoria;
                restamemoria = Double.parseDouble(display.getText()) - memoria;
                display.setText(String.valueOf(restamemoria));
            }
        });

        //Boton guardar en memoria
        MSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Guardo en memoria el valor mostrado en el display
                memoria = Double.parseDouble(display.getText());
                //Quiero que se resetee el display
                reset = true;
            }
        });

        //Boton sumar memoria
        mmasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Creo una varaible para poder sumar al display el valor de la memoria
                double sumamemoria;
                sumamemoria = Double.parseDouble(display.getText()) + memoria;
                display.setText(String.valueOf(sumamemoria));
            }
        });

        //Boton reset memoria, la igualo a 0
        MCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                memoria = 0;
            }
        });

        //Boton 7
        a7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Si quiero que no se añada a lo que hay en el display, lo elimino primero
                if (reset) {
                    display.setText("");
                }
                reset = false;
                JButton a7Button = (JButton) e.getSource();
                String texto = display.getText() + a7Button.getText();
                display.setText(texto);
            }
        });

        //Boton 8
        a8Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (reset) {
                    display.setText("");
                }
                reset = false;
                JButton a8Button = (JButton) e.getSource();
                String texto = display.getText() + a8Button.getText();
                display.setText(texto);
            }
        });

        //Boton 9
        a9Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (reset) {
                    display.setText("");
                }
                reset = false;
                JButton a9Button = (JButton) e.getSource();
                String texto = display.getText() + a9Button.getText();
                display.setText(texto);
            }
        });

        //Boton dividir
        dividir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Guardo el valor en el display como operando 1
                if(display.getText()!=null) {
                    operando1 = Double.parseDouble(display.getText());
                    //Muestro en el display el numero guardado y la operacion
                    display.setText(operando1 + " / ");
                    //Guardo la operacion que quiero hacer
                    operacion = "division";
                    //Marco que quiero que el siguiente numero resetee el display
                    reset = true;
                }
            }
        });

        //Boton 4
        a4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (reset) {
                    display.setText("");
                }
                reset = false;
                JButton a4Button = (JButton) e.getSource();
                String texto = display.getText() + a4Button.getText();
                display.setText(texto);
            }
        });

        //Boton 5
        a5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (reset) {
                    display.setText("");
                }
                reset = false;
                JButton a5Button = (JButton) e.getSource();
                String texto = display.getText() + a5Button.getText();
                display.setText(texto);
            }
        });

        //Boton 6
        a6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (reset) {
                    display.setText("");
                }
                reset = false;
                JButton a6Button = (JButton) e.getSource();
                String texto = display.getText() + a6Button.getText();
                display.setText(texto);
            }
        });

        //Boton X
        xButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Guardo el operando 1, muestro por pantalla operando1 y el simbolo X
                if(display.getText()!=null) {
                    operando1 = Double.parseDouble(display.getText());
                    display.setText(operando1 + " X ");
                    operacion = "multiplicacion";
                    reset = true;
                }
            }
        });

        //Boton 1
        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (reset) {
                    display.setText("");
                }
                reset = false;
                JButton a1Button = (JButton) e.getSource();
                String texto = display.getText() + a1Button.getText();
                display.setText(texto);
            }
        });

        //Boton 2
        a2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (reset) {
                    display.setText("");
                }
                reset = false;
                JButton a2Button = (JButton) e.getSource();
                String texto = display.getText() + a2Button.getText();
                display.setText(texto);
            }
        });

        //Boton 3
        a3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (reset) {
                    display.setText("");
                }
                reset = false;
                JButton a3Button = (JButton) e.getSource();
                String texto = display.getText() + a3Button.getText();
                display.setText(texto);
            }
        });

        //Boton resta
        resta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Guardo el operando 1, muestro por pantalla operando1 y el simbolo -
                if(display.getText()!=null) {
                    operando1 = Double.parseDouble(display.getText());
                    display.setText(operando1 + " - ");
                    operacion = "resta";
                    reset = true;
                }
            }
        });

        //Boton 0
        a0Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (reset) {
                    display.setText("");
                }
                reset = false;
                JButton a0Button = (JButton) e.getSource();
                String texto = display.getText() + a0Button.getText();
                display.setText(texto);
            }
        });

        //Boton decimales
        decimal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Separo los valores del display en un array para recorrerlo y comprobar si hay algun punto
                String[] checkdec = display.getText().split("");
                for (String x : checkdec) {
                    if (x.equals(".")) {
                        //En caso de que lo haya marco la variable a true y rompo el bucle
                        decimalused = true;
                        break;
                    }
                }
                if (!decimalused) {
                    //Si no se ha usado decimal, añado un punto
                    JButton decimal = (JButton) e.getSource();
                    String texto = display.getText() + decimal.getText();
                    display.setText(texto);
                }
                else {
                    decimalused=false;
                }


            }
        });

        //Boton suma
        suma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Guardo el operando 1, muestro por pantalla operando1 y el simbolo +
                if(display.getText()!=null) {
                    operando1 = Double.parseDouble(display.getText());
                    display.setText(operando1 + " + ");
                    operacion = "suma";
                    reset = true;
                }
            }
        });

        //Boton eliminar 1
        CEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Si hay algo en el display, devuelvo un substring con el tamaño reducido en 1
                if (display.getText().length() != 0) {
                    String ce = display.getText().substring(0, display.getText().length() - 1);
                    display.setText(ce);
                }
            }
        });

        //Boton eliminar
        cButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Elimino lo que hay en el display y pongo reset en false para que se puedan escribir numeros directamente
                display.setText("");
                reset = false;
                firstry = true;
            }

        });

        //Boton %
        porcentaje.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Si hay texto en el display, lo guardo como el porcentaje
                if (display.getText() != null&&operacion!=null&&firstry) {
                    nporcentaje = Double.parseDouble(display.getText());
                }
                else {
                    operando1 = Double.parseDouble(display.getText());
                }

                    //Se realiza el calculo segun la operacion elegida
                    switch (operacion) {
                        case "suma":
                            display.setText(String.valueOf(operando1 + (operando1 * nporcentaje / 100)));
                            break;
                        case "resta":
                            display.setText(String.valueOf(operando1 - (operando1 * nporcentaje / 100)));
                            break;
                        case "multiplicacion":
                            display.setText(String.valueOf(operando1 * (operando1 * nporcentaje / 100)));
                            break;
                        case "division":
                            display.setText(String.valueOf(operando1 / (operando1 * nporcentaje / 100)));
                            break;
                        default:
                            display.setText("Introduce valores correctos");
                    }
                    //Quiero que se resetee
                    reset = true;
                firstry = false;

            }
        });

        //Boton =
        igual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Si hay algo en el display lo guardo como operando 2
                if (display.getText() != null&&operacion!=null&&firstry) {
                    operando2 = Double.parseDouble(display.getText());
                }
                else {
                    operando1 = Double.parseDouble(display.getText());
                }

                    //Realiza la operacion elegida. Hay un fallo
                    switch (operacion) {
                        case "suma":
                            display.setText(String.valueOf(operando1 + operando2));
                            break;
                        case "resta":
                            //La primera vez lo hace bien, a partir de ahí, como el orden de los factores altera el producto, no funciona
                            double resultado = operando1 - operando2;
                            display.setText(String.valueOf(resultado));
                            break;
                        case "multiplicacion":
                            display.setText(String.valueOf(operando1 * operando2));
                            break;
                        case "division":
                            //La primera vez lo hace bien, a partir de ahí, como el orden de los factores altera el producto, no funciona
                            display.setText(String.valueOf(operando1 / operando2));
                            break;
                        default:
                            display.setText("Introduce valores correctos");
                    }
                    //Quiero que resetee el display
                    reset = true;
                    firstry=false;

            }
        });
    }

    //Main para ejecutar la calculadora
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Calculadora frame = new Calculadora();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        });
    }
}