package hw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class main {

	public static void main(String[] args) {

		Triangle tri1 = new Triangle(500);
		Triangle tri2 = new Triangle(30);
        Circle circle1 = new Circle(500);
        Circle circle2 = new Circle(30);
        Rectangle rec1 = new Rectangle(500,400);
        Rectangle rec2 = new Rectangle(20,30);
        ComposedShape work = new ComposedShape();
        
        
        JFrame frame;
        frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 414, 184);
		frame.getContentPane().add(panel); // panel reference copied
		
		JLabel containerShapeLabel = new JLabel("Container shape");
		containerShapeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		containerShapeLabel.setBounds(10, 206, 99, 14);
		frame.getContentPane().add(containerShapeLabel);
		
		JLabel lblInnerShape = new JLabel("Inner shape");
		lblInnerShape.setHorizontalAlignment(SwingConstants.CENTER);
		lblInnerShape.setBounds(120, 206, 100, 14);
		frame.getContentPane().add(lblInnerShape);
		
		JComboBox<String> cbContainerShape = new JComboBox<String>();
		cbContainerShape.setSelectedIndex(-1);
		cbContainerShape.setMaximumRowCount(3);
		cbContainerShape.setBounds(10, 227, 100, 20);
		cbContainerShape.addItem("Rectangle"); // Choice 1
		cbContainerShape.addItem("Triangle");  // Choice 2
		cbContainerShape.addItem("Circle");    // Choice 3
		frame.getContentPane().add(cbContainerShape);
		
		JComboBox<String> cbInnerShape = new JComboBox<String>();
		cbInnerShape.setSelectedIndex(-1);
		cbInnerShape.setMaximumRowCount(3);
		cbInnerShape.setBounds(120, 227, 100, 20);
		cbInnerShape.addItem("Rectangle");
		cbInnerShape.addItem("Triangle");
		cbInnerShape.addItem("Circle");
		frame.getContentPane().add(cbInnerShape);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Graphics g = panel.getGraphics(); // get brush
				g.setColor(Color.WHITE); // from now on, use white color
				g.fillRect(0, 0, panel.getWidth(), panel.getHeight()); 
				panel.paintComponents(g); // the panel will change when THIS function is executed
			}
		});
		
		btnClear.setBounds(349, 227, 75, 23);
		frame.getContentPane().add(btnClear);
		
		
		JButton btnDraw = new JButton("Draw");
		btnDraw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// Print currently selected items of combo boxes
				System.out.println(cbContainerShape.getSelectedItem());
				System.out.println(cbInnerShape.getSelectedItem());

				if(cbContainerShape.getSelectedItem()=="Rectangle" && cbInnerShape.getSelectedItem()=="Rectangle" )
					work.optimalfit(rec1, rec2);
				else if(cbContainerShape.getSelectedItem()=="Rectangle" && cbInnerShape.getSelectedItem()=="Triangle" )
					work.optimalfit(rec1, tri2);
				else if(cbContainerShape.getSelectedItem()=="Rectangle" && cbInnerShape.getSelectedItem()=="Circle" )
					work.optimalfit(rec1, circle2);
				else if(cbContainerShape.getSelectedItem()=="Triangle" && cbInnerShape.getSelectedItem()=="Rectangle" )
					work.optimalfit(tri1, rec2);
				else if(cbContainerShape.getSelectedItem()=="Triangle" && cbInnerShape.getSelectedItem()=="Triangle" )
					work.optimalfit(tri1, tri2);
				else if(cbContainerShape.getSelectedItem()=="Triangle" && cbInnerShape.getSelectedItem()=="Circle" )
					work.optimalfit(tri1, circle2);
				else if(cbContainerShape.getSelectedItem()=="Circle" && cbInnerShape.getSelectedItem()=="Rectangle" )
					work.optimalfit(circle1, rec2);
				else if(cbContainerShape.getSelectedItem()=="Circle" && cbInnerShape.getSelectedItem()=="Triangle" )
					work.optimalfit(circle1, tri2);
				else if(cbContainerShape.getSelectedItem()=="Circle" && cbInnerShape.getSelectedItem()=="Circle" )
					work.optimalfit(circle1, circle2);
				
				
			}
		});
		
		/*btnDraw.setBounds(264, 227, 75, 23);
		frame.getContentPane().add(btnDraw);*/
		
		
	

	}

}
