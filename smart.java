import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.*;

public class smart{
	//Global Fields
	
static JFrame frame;
static JPanel panel;
static CardLayout card;
static Font font;

static JTextField textField;
static JPasswordField passwordField;

static JTextField field[];
static JTextField fields[];

static DefaultTableModel model;
static JTable table;

static JPanel addPanel;
static JPanel viewPanel;
static JPanel updatePanel;
static JPanel panelButton;
static JPanel deletePanel;

static JTextField nameFieldForNamePanel;
static JTextField idFieldForIdPanel;
static JTextField brandFieldForBrandPanel;

static String customerName="";
static String medicineName="";
static double medicinePrice=0.0;
static int medicineStock=0;

static DefaultTableModel 	salesHistoryModel;
static DefaultTableModel 	purchaseHistoryModel;
static DefaultTableModel p_tableModel;
static JTable p_table;
static JLabel p_purchaseTitle = new JLabel("PURCHASE PANEL", JLabel.CENTER);
static JPanel p_purchasePanel = new JPanel(new BorderLayout());


public static void addPanel(){
	//panel for add button   
			addPanel = new JPanel(new GridLayout(9,2,10,10));  
		addPanel.setBackground(Color.BLACK);  
		addPanel.setBorder(BorderFactory.createEmptyBorder(100,200,100,200));  
		  
		//Text field array  
	 field= new JTextField[8];  
		  
		//label for id and its field  
		JLabel idLabel= new JLabel("Medicine_ID:");  
		field[0]= new JTextField(15);  
		  
		idLabel.setForeground(Color.WHITE);  
		  
		addPanel.add(idLabel);  
		addPanel.add(field[0]);  
		
		
		//label for category id and its field  
		JLabel categoryIdLabel= new JLabel("Category ID:");  
		field[1]= new JTextField(15);  
		  
		categoryIdLabel.setForeground(Color.WHITE);  
		  
		addPanel.add(categoryIdLabel);  
		addPanel.add(field[1]);
		  
		//label for name and its field  
		JLabel nameLabel= new JLabel("Name:");  
		field[2] = new JTextField(15);  
			nameLabel.setForeground(Color.WHITE);  
		addPanel.add(nameLabel);  
		addPanel.add(field[2]);  
		  
		//label for brand and its field  
		JLabel brandLabel= new JLabel("Brand:");  
		field[3] = new JTextField(15);  
			brandLabel.setForeground(Color.WHITE);  
		addPanel.add(brandLabel);  
		addPanel.add(field[3]);	  
		  
		  
		//label for Quantity and its field  
		JLabel quantityLabel= new JLabel("Quantity:");  
		field[4] = new JTextField(15);  
			quantityLabel.setForeground(Color.WHITE);  
		addPanel.add(quantityLabel);  
		addPanel.add(field[4]);  
		  
		//label for Price and its field  
		JLabel priceLabel= new JLabel("Price:");  
		field[5] = new JTextField(15);  
			priceLabel.setForeground(Color.WHITE);  
		addPanel.add(priceLabel);  
		addPanel.add(field[5]);  
		  
		//label for mfg_date and its field  
		JLabel mfgLabel= new JLabel("Manufacturing Date:");  
		field[6] = new JTextField(15);  
			mfgLabel.setForeground(Color.WHITE);  
		addPanel.add(mfgLabel);  
		addPanel.add(field[6]);  
		  
		//label for exp_date and its field  
		JLabel expLabel= new JLabel("Expiry Date:");  
		field[7] = new JTextField(15);  
			expLabel.setForeground(Color.WHITE);  
		addPanel.add(expLabel);  
		addPanel.add(field[7]);  
		  
		//setting of panels  
		panel.add(addPanel,"addPanel");  
		  
}
public static void viewPanel(){
	//panel for view button  
			 viewPanel= new JPanel(new BorderLayout());  
			viewPanel.setBackground(Color.BLACK);  
				viewPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));  
			  
			//column names for header  
			String column[]={"medicine_id","category_id","name","brand","quantity","price","mfg","exp"};				//table model for dynamic rows  
		model = new DefaultTableModel();

model.setColumnIdentifiers(column);

	table = new JTable(model);  
	
	table.setForeground(Color.WHITE);
	
	table.setBackground(Color.BLACK);

	table.getTableHeader().					setForeground(Color.WHITE);

	table.getTableHeader().setBackground(Color.DARK_GRAY);

			JScrollPane sp= new JScrollPane(table);  
			  
			viewPanel.add(sp,BorderLayout.CENTER);  
			  
			panelButton= new JPanel();  
			panelButton.setBackground(Color.BLACK);  
			panelButton.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));  
			viewPanel.add(panelButton, BorderLayout.SOUTH);
			panel.add(viewPanel,"view");
}
public static void updatePanel(){
		//panel for update button   
		updatePanel = new JPanel(new GridLayout(9,2,10,10));  
		updatePanel.setBackground(Color.BLACK);  
		updatePanel.setBorder(BorderFactory.createEmptyBorder(100,200,100,200));  
		  
		//Text field array  
		fields= new JTextField[8];  
		  
		//label for id and its field  
		JLabel idLabelUpdate= new JLabel("Medicine ID:");  
		fields[0]= new JTextField(15);  
			idLabelUpdate.setForeground(Color.WHITE);  
		updatePanel.add(idLabelUpdate);  
		updatePanel.add(fields[0]);  
		
		//label for category id and its field  
		JLabel categoryIdLabelUpdate= new JLabel("Category ID:");  
		fields[1]= new JTextField(15);  
			categoryIdLabelUpdate.setForeground(Color.WHITE);  
		updatePanel.add(categoryIdLabelUpdate);  
		updatePanel.add(fields[1]);
		  
		//label for name and its field  
		JLabel nameLabelUpdate= new JLabel("Name:");  
		fields[2] = new JTextField(15);  
		nameLabelUpdate.setForeground(Color.WHITE);  
		updatePanel.add(nameLabelUpdate);  
		updatePanel.add(fields[2]);  
		  
		//label for brand and its field  
		JLabel brandLabelUpdate= new JLabel("Brand:");  
		fields[3] = new JTextField(15);  
		brandLabelUpdate.setForeground(Color.WHITE);  
		updatePanel.add(brandLabelUpdate);  
		updatePanel.add(fields[3]);	  
		  
		  
		//label for Quantity and its field  
		JLabel quantityLabelUpdate= new JLabel("Quantity:");  
		fields[4] = new JTextField(15);  
		quantityLabelUpdate.setForeground(Color.WHITE);  
		updatePanel.add(quantityLabelUpdate);  
		updatePanel.add(fields[4]);  
		  
		//label for Price and its field  
		JLabel priceLabelUpdate= new JLabel("Price:");  
		fields[5] = new JTextField(15);  
		priceLabelUpdate.setForeground(Color.WHITE);  
		updatePanel.add(priceLabelUpdate);  
		updatePanel.add(fields[5]);  
		  
		//label for mfg_date and its field  
		JLabel mfgLabelUpdate= new JLabel("Manufacturing Date:");  
		fields[6] = new JTextField(15);  
		mfgLabelUpdate.setForeground(Color.WHITE);  
		updatePanel.add(mfgLabelUpdate);  
		updatePanel.add(fields[6]);  
		  
		//label for exp_date and its field  
		JLabel expLabelUpdate= new JLabel("Expiry Date:");  
		fields[7] = new JTextField(15);  
		expLabelUpdate.setForeground(Color.WHITE);  
		updatePanel.add(expLabelUpdate);  
		updatePanel.add(fields[7]);  
		  
		//setting of panels  
		panel.add(updatePanel,"updatePanel");  
}
public static void createBackButton(JPanel targetPanel){
	// back button 
		JButton backButton= new JButton("Back");  
		backButton.setBackground(Color.LIGHT_GRAY);  
		backButton.setFont(font);  
		backButton.setFocusPainted(false);  
		backButton.setForeground(Color.BLACK);  
		backButton.setPreferredSize(new Dimension(120,35));  
		targetPanel.add(backButton);  
		backButton.addActionListener(evv->{  
		card.show(panel,"dash");  
		});  
}


public static void saveButtonForAdd(JPanel targetPanel){
	//Save button for inserting data  
		JButton saveButton= new JButton("Save");  
		saveButton.setFont(font);  
	saveButton.setPreferredSize(new Dimension(120,35));  
	saveButton.setBackground(Color.LIGHT_GRAY);  
	saveButton.setForeground(Color.BLACK);  
	saveButton.setFocusPainted(false);  
		targetPanel.add(saveButton);  
		saveButton.addActionListener(e->{  
		  
		String id= field[0].getText();  
		String category_id= field[1].getText();  
		String name= field[2].getText();  
		String brand=field[3].getText();  
		int quantity=Integer.parseInt(field[4].getText());  
		double price= Double.parseDouble(field[5].getText());  
		String mfg= field[6].getText();  
		String exp=field[7].getText();  
		  
		try {
    new MedicineService().add(
        field[0].getText(),
        field[1].getText(),
        field[2].getText(),
        field[3].getText(),
        Integer.parseInt(field[4].getText()),
        Double.parseDouble(field[5].getText()),
        field[6].getText(),
        field[7].getText()
    );

    JOptionPane.showMessageDialog(frame, "Medicine Added Successfully!");

} catch (Exception ex) {
    ex.printStackTrace();
}
		});	
}

public static void saveButtonForUpdate(JPanel targetPanel){
	//Save button for inserting data  
		JButton saveButton= new JButton("Save");  
		saveButton.setFont(font);  
	saveButton.setPreferredSize(new Dimension(120,35));  
	saveButton.setBackground(Color.LIGHT_GRAY);  
	saveButton.setForeground(Color.BLACK);  
	saveButton.setFocusPainted(false);  
		targetPanel.add(saveButton);  
		saveButton.addActionListener(e->{  
		  
		String id= fields[0].getText();  
		String category_id= fields[1].getText();  
		String name= fields[2].getText();  
		String brand=fields[3].getText();  
		int quantity=Integer.parseInt(fields[4].getText());  
		double price= Double.parseDouble(fields[5].getText());  
		String mfg= fields[6].getText();  
		String exp=fields[7].getText();  
		  
		try {
    new MedicineService().update(
        fields[0].getText(),
        fields[1].getText(),
        fields[2].getText(),
        fields[3].getText(),
        Integer.parseInt(fields[4].getText()),
        Double.parseDouble(fields[5].getText()),
        fields[6].getText(),
        fields[7].getText()
    );

    JOptionPane.showMessageDialog(frame, "Medicine Updated Successfully!");

} catch (Exception ex) {
    ex.printStackTrace();
}
		});	
}

public static void createSearchButtonForId(JPanel targetPanel){
			  	//search button for id Button
		JButton searchButton= new JButton("Search");
		searchButton.setBackground(Color.LIGHT_GRAY);
		searchButton.setForeground(Color.BLACK);
		searchButton.setPreferredSize(new Dimension(120,35));
		searchButton.setFont(font);
		searchButton.setFocusPainted(false);  
	searchButton.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));  
	targetPanel.add(searchButton);
	
	//Table for search button 
		
			
	
	//search button listener
		  searchButton.addActionListener(e->{
				model.setRowCount(0);

try {
    ResultSet rs = new MedicineService()
        .search("medicine_id", idFieldForIdPanel.getText());

    while (rs.next()) {
        model.addRow(new Object[]{
            rs.getString("medicine_id"),
            rs.getString("category_id"),
            rs.getString("name"),
            rs.getString("brand"),
            rs.getInt("quantity"),
            rs.getDouble("price"),
            rs.getString("mfg"),
            rs.getString("exp")
        });
    }
    card.show(panel,"view");

} catch (Exception ex) {
    ex.printStackTrace();
}
			
		});
}

public static void createSearchButtonForName(JPanel targetPanel){
			  	//search button for id Button
		JButton searchButton= new JButton("Search");
		searchButton.setBackground(Color.LIGHT_GRAY);
		searchButton.setForeground(Color.BLACK);
		searchButton.setPreferredSize(new Dimension(120,35));
		searchButton.setFont(font);
		searchButton.setFocusPainted(false);  
	searchButton.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));  
	targetPanel.add(searchButton);
	
	//Table for search button 
			  	//column names for header  
			
	
	//search button listener
		  searchButton.addActionListener(e->{
				model.setRowCount(0);

try {
    ResultSet rs = new MedicineService()
        .search("name", nameFieldForNamePanel.getText());

    while (rs.next()) {
        model.addRow(new Object[]{
            rs.getString("medicine_id"),
            rs.getString("category_id"),
            rs.getString("name"),
            rs.getString("brand"),
            rs.getInt("quantity"),
            rs.getDouble("price"),
            rs.getString("mfg"),
            rs.getString("exp")
        });
    }
    card.show(panel,"view");

} catch (Exception ex) {
    ex.printStackTrace();
}
			
		});
}

public static void createSearchButtonForBrand(JPanel targetPanel){
			  	//search button for brand Button
		JButton searchButton= new JButton("Search");
		searchButton.setBackground(Color.LIGHT_GRAY);
			searchButton.setForeground(Color.BLACK);
		searchButton.setPreferredSize(new Dimension(120,35));
		searchButton.setFont(font);
		searchButton.setFocusPainted(false);  
	searchButton.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));  
	targetPanel.add(searchButton); 
	
	//search button listener
		  searchButton.addActionListener(e->{
				model.setRowCount(0);

try {
    ResultSet rs = new MedicineService()
        .search("brand", brandFieldForBrandPanel.getText());

    while (rs.next()) {
        model.addRow(new Object[]{
            rs.getString("medicine_id"),
            rs.getString("category_id"),
            rs.getString("name"),
            rs.getString("brand"),
            rs.getInt("quantity"),
            rs.getDouble("price"),
            rs.getString("mfg"),
            rs.getString("exp")
        });
    }

} catch (Exception ex) {
    ex.printStackTrace();
}

card.show(panel,"view");
			
		});
}
public static void dashPanel(){
	
}

public static void main(String[] args) {

// Main Frame  
	 frame = new JFrame();  
	frame.setTitle("Smart_Medical_Store_System");  
	frame.setSize(800,600);  
	frame.setResizable(false);  
	frame.getContentPane().setBackground(Color.BLACK);  
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  

	  
	  //Font
	 font = new Font("Segoe UI",Font.BOLD,15);  
	  
	//Main Panel   
	panel = new JPanel();  
	panel.setBackground(Color.BLACK);  
	panel.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));  
	//CardLayout for smooth switching between panels and adding of main panel into frame  
	 card = new CardLayout();  
	panel.setLayout(card);  
	frame.add(panel);  
	  
	//image for project  
	ImageIcon icon= new ImageIcon("Hospital.png");  
	  
	//1_Image Panel for admin panel  
	JPanel imagePanel= new JPanel();  
	imagePanel.setBackground(Color.BLACK);  
	imagePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));  
	JLabel imageLabel= new JLabel("Welcome",icon,JLabel.CENTER);  
	imageLabel.setHorizontalAlignment(JLabel.CENTER);  
	imageLabel.setVerticalTextPosition(JLabel.BOTTOM);  
	imageLabel.setHorizontalTextPosition(JLabel.CENTER);  
	imageLabel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));  
	imageLabel.setFont(font);  
	imageLabel.setForeground(Color.WHITE);  
	imageLabel.setIconTextGap(15);  
	//add into main panel  
	imagePanel.add(imageLabel);  
	  
	  
	//2_panel for layout and admin use  
	JPanel loginPanel = new JPanel(new GridLayout(6,1,10,20));  
	loginPanel.setBackground(Color.BLACK);  
	loginPanel.setBorder(BorderFactory.createEmptyBorder(20,50,20,50));  
	  
	//username label and text field   
	JLabel username= new JLabel("Username:");  
	username.setForeground(Color.WHITE);  
	textField = new JTextField(15);  
	  
	loginPanel.add(username);  
	loginPanel.add(textField );  
  
	  
	//Password  label and Password field   
	JLabel password= new JLabel("Password:");  
	password.setForeground(Color.WHITE);  
	passwordField = new JPasswordField(15);  
	  
	loginPanel.add(password);  
	loginPanel.add(passwordField );  
  
	// Login Button  
	JButton loginButton= new JButton("Login");  
	loginButton.setBackground(Color.LIGHT_GRAY);  
	loginButton.setFont(font);  
	loginButton.setPreferredSize(new Dimension(120,35));  
	loginButton.setFocusPainted(false);  
	loginButton.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));  
	loginPanel.add(loginButton );  
	  
	  
	//combined panel screen login  
	JPanel loginScreen = new JPanel(new BorderLayout());  
	  
	loginScreen.add(imagePanel,BorderLayout.NORTH);  
	loginScreen.add(loginPanel,BorderLayout.CENTER);  
	panel.add(loginScreen,"screen");  
	  
	card.show(panel,"screen");  
	  
	  
	  
	  
	  
	//Dashboard Main Panel  
	JPanel dashPanel= new JPanel();  
	dashPanel.setBackground(Color.BLACK);  
	dashPanel.setLayout(new BorderLayout());  
	//panel for dashboard name  
	JPanel dashboardNamePanel= new JPanel();  
	  
	JLabel dashboardLabel= new JLabel("DashBoard",JLabel.CENTER);  
	dashboardLabel.setFont(new Font("Segoe UI",Font.BOLD,36)  );  
	dashboardLabel.setBorder(BorderFactory.createEmptyBorder(20,0,20,0));
	dashboardLabel.setHorizontalAlignment(JLabel.CENTER);
	dashboardLabel.setForeground(Color.WHITE);  
	dashPanel.add(dashboardLabel,BorderLayout.NORTH);  
	  
	//Panel for Buttons  
	JPanel buttonPanel= new JPanel();  
	buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER,30,50));  
	JButton button[]= new JButton[10];  
	button[0]= new JButton("Add");  
	button[1]=new JButton("View ");  
	button[2]= new JButton("Update");  
	button[3]= new JButton("Delete");  
	button[4]= new JButton("Search");
	button[5]= new JButton("Sales");
	button[6]= new JButton("Sales History");
	button[7]= new JButton("Purchase");
	button[8]= new JButton("Purchase History");
	button[9]= new JButton("Logout");  
	  
	for(int i=0;i<10;i++){  
	button[i].setFont(font);  
	button[i].setPreferredSize(new Dimension(150,50));  
	button[i].setBackground(Color.LIGHT_GRAY);  
	button[i].setForeground(Color.BLACK);  
	button[i].setFocusPainted(false);  
	button[i].setBorder(BorderFactory.createLineBorder(Color.GRAY,1));  
	buttonPanel.add(button[i]);  
	}  
	  
	  
	dashPanel.add(buttonPanel,BorderLayout.CENTER);  
panel.add(dashPanel,"dash");  
  
	  
	  
	  
	  
	  
	//Login button logic  
	loginButton.addActionListener(e ->  
		{  
			//string fields in variables  
String usernameInput= textField.getText();  
String passwordInput= new String(passwordField.getPassword());  
AuthService auth = new AuthService();

if (auth.login(usernameInput, passwordInput)) {
    card.show(panel, "dash");
    textField.setText("");
    passwordField.setText("");
} else {
    JOptionPane.showMessageDialog(frame, "Invalid Username or Password");
}
		});
		  
		  
		  
		  
		  
		  
		  //Add Panel Method
		smart.addPanel();
		  //Save button add method
		smart.saveButtonForAdd(addPanel);
		//Method for back button add  
		smart.createBackButton(addPanel);
					  
		  
		//add button Listener  
		button[0].addActionListener(e-> {  
			card.show(panel,"addPanel");  
	});;  
	  
	  
	  
	  
	  
	  
	  
	  
	  //View panel method
		smart.viewPanel();
	//method for back button view
		smart.createBackButton(panelButton);
							  
		//View Button Listener  
		button[1].addActionListener(e-> {  
				model.setRowCount(0);

try {
    ResultSet rs = new MedicineService().getAll();

    while (rs.next()) {
        model.addRow(new Object[]{
            rs.getString("medicine_id"),
            rs.getString("category_id"),
            rs.getString("name"),
            rs.getString("brand"),
            rs.getInt("quantity"),
            rs.getDouble("price"),
            rs.getString("mfg"),
            rs.getString("exp")
        });
    }
    card.show(panel,"view");

} catch (Exception ex) {
    ex.printStackTrace();
}
					  
		});  
		  
		  
		
		  //Update panel method
			smart.updatePanel();
		  
		  //method for save button update
			smart.saveButtonForUpdate(updatePanel);
		  //method for back button update
			smart.createBackButton(updatePanel);
		  
			//Update button Listener  
		button[2].addActionListener(e-> {  
			card.show(panel,"updatePanel");  
	});;  
		  
		  //Delete button panel
		   deletePanel = new JPanel(new FlowLayout(FlowLayout.CENTER,20,40));
		  deletePanel.setBackground(Color.BLACK);
		  deletePanel.setFont(font);
		  deletePanel.setBorder(BorderFactory.createEmptyBorder(150,200,150,200));
		  panel.add(deletePanel,"delete");
		  
		  //text field and label for id
		  JLabel idLabel=new JLabel("Enter ID:");
		  idLabel.setForeground(Color.WHITE);
		  JTextField idField=new JTextField();
		  idField.setPreferredSize(new Dimension(150,30));
			deletePanel.add(idLabel);
		  deletePanel.add(idField);
		  //Method for back button of delete button
		  smart.createBackButton(deletePanel);
		  
		  //Execute button
		  JButton executeButton= new JButton("Execute");
		  executeButton.setBackground(Color.LIGHT_GRAY);  
		executeButton.setFont(font);  
		executeButton.setFocusPainted(false);  
		executeButton.setForeground(Color.BLACK);  
		executeButton.setPreferredSize(new Dimension(120,35));  
		deletePanel.add(executeButton);
		
		executeButton.addActionListener(e->{
				String id=idField.getText();
				
			try {
    new MedicineService().delete(idField.getText());
    JOptionPane.showMessageDialog(frame, "Deleted Successfully!");
} catch (Exception ex) {
    ex.printStackTrace();
}
			
		});
		
		//listener for delete panel
		button[3].addActionListener(e->{
			card.show(panel,"delete");
	});
	
	//listener for logout panel
		button[9].addActionListener(e->{
			card.show(panel,"screen");
		});
		
		//panel for search button
			JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,20,40));
		searchPanel.setBackground(Color.BLACK);
		searchPanel.setBorder(BorderFactory.createEmptyBorder(150,200,150,200));
	
		searchPanel.setFont(font);

		//search by id button
		JButton idButton= new JButton("Search by ID");
		idButton.setForeground(Color.BLACK);
		idButton.setFont(font);
		idButton.setPreferredSize(new Dimension(120,35));
		idButton.setFocusPainted(false);  
	idButton.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));  
	searchPanel.add(idButton);
	panel.add(searchPanel,"search");
	
	//panel for id button
	JPanel idButtonPanel= new JPanel(new FlowLayout(FlowLayout.CENTER,20,40));
		  idButtonPanel.setBackground(Color.BLACK);
		  idButtonPanel.setFont(font);
		  idButtonPanel.setBorder(BorderFactory.createEmptyBorder(150,200,150,200));
		  panel.add(idButtonPanel,"idPanel");
		  
		  //text field and label for id
		  JLabel idLabelForIdPanel=new JLabel("Enter ID:");
		  idLabelForIdPanel.setForeground(Color.WHITE);
		   idFieldForIdPanel=new JTextField();
		   idFieldForIdPanel.setPreferredSize(new Dimension(150,30));
			idButtonPanel.add(idLabelForIdPanel);
		  idButtonPanel.add(idFieldForIdPanel);
		  
		  //create back button for id button 
		  smart.createBackButton(idButtonPanel);
		  
		  //create search button for id button
smart.createSearchButtonForId(idButtonPanel);

	//listener of id button 
	idButton.addActionListener(e->{
		card.show(panel,"idPanel");
	});
	
	//listener for search button 
	button[4].addActionListener(e->{
		card.show(panel,"search");
	});
	
	
	//search by Name button
		JButton nameButton= new JButton("Search by Name");
		nameButton.setForeground(Color.BLACK);
			nameButton.setPreferredSize(new Dimension(120,35));
		nameButton.setFont(font);
		nameButton.setFocusPainted(false);  
	nameButton.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));  
	searchPanel.add(nameButton);
	
	//search by Brand Button
		JButton brandButton= new JButton("Search by Brand");
		brandButton.setForeground(Color.BLACK);
			brandButton.setPreferredSize(new Dimension(120,35));
		brandButton.setFont(font);
		brandButton.setFocusPainted(false);  
	brandButton.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));  
	searchPanel.add(brandButton);
	
	//Back button for search panel
	smart.createBackButton(searchPanel);
	
	
	//panel for name button
	JPanel nameButtonPanel= new JPanel(new FlowLayout(FlowLayout.CENTER,20,40));
		  nameButtonPanel.setBackground(Color.BLACK);
		  nameButtonPanel.setFont(font);
		  nameButtonPanel.setBorder(BorderFactory.createEmptyBorder(150,200,150,200));
		  panel.add(nameButtonPanel,"namePanel");
		  
		  //text field and label for name
		  JLabel nameLabelForNamePanel=new JLabel("Enter Name:");
		  nameLabelForNamePanel.setForeground(Color.WHITE);
		  nameFieldForNamePanel=new JTextField();
		   nameFieldForNamePanel.setPreferredSize(new Dimension(150,30));
			nameButtonPanel.add(nameLabelForNamePanel);
		  nameButtonPanel.add(nameFieldForNamePanel);
		  //create back button for name button panel
		  smart.createBackButton(nameButtonPanel);
		  
		  //create search button for name button
		smart.createSearchButtonForName(nameButtonPanel);
	//listener of name button 
	nameButton.addActionListener(e->{
		card.show(panel,"namePanel");
	});
	
	
	//panel for brand button
	JPanel brandButtonPanel= new JPanel(new FlowLayout(FlowLayout.CENTER,20,40));
		  brandButtonPanel.setBackground(Color.BLACK);
		  brandButtonPanel.setFont(font);
		  brandButtonPanel.setBorder(BorderFactory.createEmptyBorder(150,200,150,200));
		  panel.add(brandButtonPanel,"brandPanel");
		  
		  //text field and label for brand
		  JLabel brandLabelForBrandPanel=new JLabel("Enter Brand:");
		  brandLabelForBrandPanel.setForeground(Color.WHITE);
		   brandFieldForBrandPanel=new JTextField();
		    brandFieldForBrandPanel.setPreferredSize(new Dimension(150,30));
		 	brandButtonPanel.add(brandLabelForBrandPanel);
		  brandButtonPanel.add(brandFieldForBrandPanel);
		  //create back button for brand button panel
		  smart.createBackButton(brandButtonPanel);
		  
		  //create search button for brand button
			smart.createSearchButtonForBrand(brandButtonPanel);

	//listener of brand button 
	brandButton.addActionListener(e->{
		card.show(panel,"brandPanel");
	});
	
		frame.setVisible(true);  
		
		
		
		
// ================= SALES PANEL =================
JPanel salesPanel = new JPanel(new BorderLayout());
salesPanel.setBackground(Color.BLACK);
panel.add(salesPanel, "sales");

// ================= TITLE =================
JLabel salesTitle = new JLabel("SALES PANEL", JLabel.CENTER);
salesTitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
salesTitle.setForeground(Color.WHITE);

// ================= CUSTOMER + MEDICINE PANEL =================
JPanel salesInputPanel = new JPanel(new GridLayout(1,2,10,10));
salesInputPanel.setBackground(Color.BLACK);

// ---------- CUSTOMER ----------
JTextField customerIdField = new JTextField();
JLabel customerNameLabel = new JLabel("");
customerNameLabel.setForeground(Color.WHITE);

JButton searchCustomerBtn = new JButton("Search");

JPanel customerPanel = new JPanel(new GridLayout(3,2,5,5));
customerPanel.setBackground(Color.BLACK);

JLabel c1 = new JLabel("Customer ID"); c1.setForeground(Color.WHITE);
JLabel c2 = new JLabel("Customer Name"); c2.setForeground(Color.WHITE);

customerPanel.add(c1);
customerPanel.add(customerIdField);
customerPanel.add(c2);
customerPanel.add(customerNameLabel);
customerPanel.add(new JLabel(""));
customerPanel.add(searchCustomerBtn);

// ---------- MEDICINE ----------
JTextField medicineIdField = new JTextField();
JLabel medicineNameLabel = new JLabel(""); medicineNameLabel.setForeground(Color.WHITE);
JLabel medicinePriceLabel = new JLabel(""); medicinePriceLabel.setForeground(Color.WHITE);
JLabel medicineStockLabel = new JLabel(""); medicineStockLabel.setForeground(Color.WHITE);
JTextField quantityField = new JTextField();

JButton searchMedicineBtn = new JButton("Search Medicine");
JButton addToCartBtn = new JButton("Add To Cart");
JButton saveSaleBtn = new JButton("Save Sale");
JButton clearSaleBtn = new JButton("Clear");

JButton backButtonSales= new JButton("Back");  
		backButtonSales.setBackground(Color.LIGHT_GRAY);  
		backButtonSales.setFont(font);  
		backButtonSales.setFocusPainted(false);  
		backButtonSales.setForeground(Color.BLACK);  
		backButtonSales.setPreferredSize(new Dimension(120,35));  
		backButtonSales.addActionListener(evv->{  
		card.show(panel,"dash");  
		});  
		
JPanel medicinePanel = new JPanel(new GridLayout(0,2,10,10));
medicinePanel.setBackground(Color.BLACK);

JLabel m1 = new JLabel("Medicine ID"); m1.setForeground(Color.WHITE);
JLabel m2 = new JLabel("Name"); m2.setForeground(Color.WHITE);
JLabel m3 = new JLabel("Price"); m3.setForeground(Color.WHITE);
JLabel m5 = new JLabel("Quantity"); m5.setForeground(Color.WHITE);

medicinePanel.add(m1);
medicinePanel.add(medicineIdField);
medicinePanel.add(m2);
medicinePanel.add(medicineNameLabel);
medicinePanel.add(m3);
medicinePanel.add(medicinePriceLabel);
medicinePanel.add(m5);
medicinePanel.add(quantityField);
medicinePanel.add(searchMedicineBtn);
medicinePanel.add(addToCartBtn);
medicinePanel.add(saveSaleBtn);
medicinePanel.add(clearSaleBtn);
medicinePanel.add(backButtonSales);

salesInputPanel.add(customerPanel);
salesInputPanel.add(medicinePanel);

// ===== FIX: WRAP TITLE + INPUT PANEL =====
JPanel topPanel = new JPanel(new BorderLayout());
topPanel.setBackground(Color.BLACK);
topPanel.add(salesTitle, BorderLayout.NORTH);
topPanel.add(salesInputPanel, BorderLayout.CENTER);

salesPanel.add(topPanel, BorderLayout.NORTH);

// ================= TABLE =================
String salesColumns[] = {"Customer ID","Medicine ID","Name","Price","Qty","Total"};
DefaultTableModel salesTableModel = new DefaultTableModel(salesColumns,0);
JTable salesTable = new JTable(salesTableModel);

salesPanel.add(new JScrollPane(salesTable), BorderLayout.CENTER);

// ================= ACTIONS =================

// CUSTOMER SEARCH
searchCustomerBtn.addActionListener(e -> {
    try {
    ResultSet rs = new SalesService().getCustomer(customerIdField.getText());

    if (rs.next()) {
        customerNameLabel.setText(rs.getString("name"));
    } else {
        JOptionPane.showMessageDialog(null, "Customer not found!");
    }

} catch (Exception ex) {
    ex.printStackTrace();
}
});

// MEDICINE SEARCH
searchMedicineBtn.addActionListener(e -> {
    try {
    ResultSet rs = new SalesService().getMedicine(medicineIdField.getText());

    if (rs.next()) {
        medicineNameLabel.setText(rs.getString("name"));
        medicinePriceLabel.setText(rs.getString("price"));
        medicineStockLabel.setText(rs.getString("quantity"));
    } else {
        JOptionPane.showMessageDialog(null, "Medicine not found!");
    }

} catch (Exception ex) {
    ex.printStackTrace();
}
});

// ADD TO CART
addToCartBtn.addActionListener(e -> {

    if(medicinePriceLabel.getText().isEmpty() || quantityField.getText().isEmpty()){
        JOptionPane.showMessageDialog(null,"Fill all fields!");
        return;
    }

    double price = Double.parseDouble(medicinePriceLabel.getText());
    int qty = Integer.parseInt(quantityField.getText());

    salesTableModel.addRow(new Object[]{
        customerIdField.getText(),
        medicineIdField.getText(),
        medicineNameLabel.getText(),
        price,
        qty,
        price * qty
    });
});

// SAVE SALE
saveSaleBtn.addActionListener(e -> {

    Connection con = null;

    try {

        if (customerIdField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter Customer ID!");
            return;
        }

        if (salesTableModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Cart is empty!");
            return;
        }

        con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/medical_store",
                "root",
                "12345"
        );

        con.setAutoCommit(false);

        // ================= INSERT SALES (NO TOTAL PRICE) =================
        PreparedStatement saleInsert = con.prepareStatement(
                "INSERT INTO sales(customer_id, date) VALUES (?, NOW())",
                Statement.RETURN_GENERATED_KEYS
        );

        saleInsert.setString(1, customerIdField.getText());
        saleInsert.executeUpdate();

        ResultSet rs = saleInsert.getGeneratedKeys();

        int saleId = 0;
        if (rs.next()) {
            saleId = rs.getInt(1);
        }

        // ================= DETAILS =================
        PreparedStatement detailInsert = con.prepareStatement(
                "INSERT INTO sales_detail(sale_id, medicine_id, quantity, price, total) VALUES (?,?,?,?,?)"
        );

        // ================= STOCK UPDATE =================
        PreparedStatement stockUpdate = con.prepareStatement(
                "UPDATE medicine SET quantity = quantity - ? WHERE medicine_id = ?"
        );

        for (int i = 0; i < salesTableModel.getRowCount(); i++) {

            String medId = salesTableModel.getValueAt(i, 1).toString();
            int qty = Integer.parseInt(salesTableModel.getValueAt(i, 4).toString());
            double price = Double.parseDouble(salesTableModel.getValueAt(i, 3).toString());
            double total = qty * price;

            detailInsert.setInt(1, saleId);
            detailInsert.setString(2, medId);
            detailInsert.setInt(3, qty);
            detailInsert.setDouble(4, price);
            detailInsert.setDouble(5, total);
            detailInsert.executeUpdate();

            stockUpdate.setInt(1, qty);
            stockUpdate.setString(2, medId);
            stockUpdate.executeUpdate();
        }

        con.commit();

        // CLEAR CART
        salesTableModel.setRowCount(0);

        JOptionPane.showMessageDialog(null, "Sale Saved Successfully!");

    } catch (Exception ex) {

        try {
            if (con != null) con.rollback();
        } catch (Exception e2) {
            e2.printStackTrace();
        }

        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, ex.getMessage());
    }
});

// CLEAR
clearSaleBtn.addActionListener(e -> {
    medicineIdField.setText("");
    quantityField.setText("");
    medicineNameLabel.setText("");
    medicinePriceLabel.setText("");
    medicineStockLabel.setText("");
});
//================== Sales History Panel ==============

JPanel salesHistoryPanel = new JPanel(new BorderLayout());
salesHistoryPanel.setBackground(Color.BLACK);
panel.add(salesHistoryPanel, "salesHistory");

// ================= TITLE =================
JLabel historyLabel = new JLabel("Sales History", JLabel.CENTER);
historyLabel.setForeground(Color.WHITE);
historyLabel.setFont(new Font("Segoe UI", Font.BOLD, 36));
salesHistoryPanel.add(historyLabel, BorderLayout.NORTH);

// ================= TABLE PANEL =================
JPanel tablePanel = new JPanel(new GridLayout(2, 1, 10, 10));
tablePanel.setBackground(Color.BLACK);
salesHistoryPanel.add(tablePanel, BorderLayout.CENTER);

// ================= SALES TABLE =================
String salesCols[] = {"Sale ID", "Customer ID", "Date"};

salesHistoryModel = new DefaultTableModel(salesCols, 0);
JTable salesHistoryTable = new JTable(salesHistoryModel);

// Style
salesHistoryTable.setBackground(Color.BLACK);
salesHistoryTable.setForeground(Color.WHITE);
salesHistoryTable.setGridColor(Color.GRAY);
salesHistoryTable.setSelectionBackground(Color.DARK_GRAY);
salesHistoryTable.setSelectionForeground(Color.WHITE);
salesHistoryTable.getTableHeader().setBackground(Color.BLACK);
salesHistoryTable.getTableHeader().setForeground(Color.WHITE);

// ================= BACK BUTTON =================
JButton salesBackButton = new JButton("Back");
salesBackButton.setBackground(Color.LIGHT_GRAY);
salesBackButton.setForeground(Color.BLACK);
salesBackButton.setFont(new Font("Segoe UI", Font.BOLD, 14));

salesHistoryPanel.add(salesBackButton, BorderLayout.SOUTH);

salesBackButton.addActionListener(e -> {
    card.show(panel, "dash");
});

JScrollPane salesScroll = new JScrollPane(salesHistoryTable);
salesScroll.getViewport().setBackground(Color.BLACK);
tablePanel.add(salesScroll);

// ================= SALES DETAIL TABLE =================
String detailCols[] = {"Sale ID", "Medicine ID", "Name", "Price", "Qty", "Total"};

DefaultTableModel salesDetailModel = new DefaultTableModel(detailCols, 0);
JTable salesDetailTable = new JTable(salesDetailModel);

// Style
salesDetailTable.setBackground(Color.BLACK);
salesDetailTable.setForeground(Color.WHITE);
salesDetailTable.setGridColor(Color.GRAY);
salesDetailTable.setSelectionBackground(Color.DARK_GRAY);
salesDetailTable.setSelectionForeground(Color.WHITE);
salesDetailTable.getTableHeader().setBackground(Color.BLACK);
salesDetailTable.getTableHeader().setForeground(Color.WHITE);

JScrollPane detailScroll = new JScrollPane(salesDetailTable);
detailScroll.getViewport().setBackground(Color.BLACK);
tablePanel.add(detailScroll);


//====================================================
//                 DATABASE LOAD
//====================================================

try {
    SalesService ss = new SalesService();

    ResultSet rs1 = ss.getSalesHistory();
    salesHistoryModel.setRowCount(0);

    while (rs1.next()) {
        salesHistoryModel.addRow(new Object[]{
            rs1.getInt("sale_id"),
            rs1.getInt("customer_id"),
            rs1.getString("date")
        });
    }

    ResultSet rs2 = ss.getSalesDetails();
    salesDetailModel.setRowCount(0);

    while (rs2.next()) {
        salesDetailModel.addRow(new Object[]{
            rs2.getInt("sale_id"),
            rs2.getInt("medicine_id"),
            rs2.getString("name"),
            rs2.getDouble("price"),
            rs2.getInt("quantity"),
            rs2.getDouble("total")
        });
    }



} catch (Exception ex) {
    ex.printStackTrace();
}


JPanel p_inputPanel = new JPanel(new GridLayout(1,2,10,10));
p_inputPanel.setBackground(Color.BLACK);

// ---------- SUPPLIER ----------
JTextField p_supplierIdField = new JTextField();
JLabel p_supplierNameLabel = new JLabel("");
p_supplierNameLabel.setForeground(Color.WHITE);

JButton p_searchSupplierBtn = new JButton("Search");

p_searchSupplierBtn.addActionListener(e -> {
    try {
        ResultSet rs = new PurchaseService().getSupplier(p_supplierIdField.getText());

        if (rs.next()) {
            p_supplierNameLabel.setText(rs.getString("supplier_name"));
        } else {
            JOptionPane.showMessageDialog(null, "Supplier not found!");
        }

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, ex.getMessage());
    }
});



JPanel p_supplierPanel = new JPanel(new GridLayout(3,2,5,5));
p_supplierPanel.setBackground(Color.BLACK);

JLabel p_s1 = new JLabel("Supplier ID"); p_s1.setForeground(Color.WHITE);
JLabel p_s2 = new JLabel("Supplier Name"); p_s2.setForeground(Color.WHITE);

p_supplierPanel.add(p_s1);
p_supplierPanel.add(p_supplierIdField);
p_supplierPanel.add(p_s2);
p_supplierPanel.add(p_supplierNameLabel);
p_supplierPanel.add(new JLabel(""));
p_supplierPanel.add(p_searchSupplierBtn);

// ---------- MEDICINE ----------
JTextField p_medicineIdField = new JTextField();
JLabel p_medicineNameLabel = new JLabel(""); p_medicineNameLabel.setForeground(Color.WHITE);
JLabel p_medicinePriceLabel = new JLabel(""); p_medicinePriceLabel.setForeground(Color.WHITE);
JTextField p_qtyField = new JTextField();

JButton p_searchMedicineBtn = new JButton("Search Medicine");

p_searchMedicineBtn.addActionListener(e -> {
    try {
        ResultSet rs = new PurchaseService().getMedicine(p_medicineIdField.getText());

        if (rs.next()) {
            p_medicineNameLabel.setText(rs.getString("name"));
            p_medicinePriceLabel.setText(rs.getString("price"));
        } else {
            JOptionPane.showMessageDialog(null, "Medicine not found!");
        }

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, ex.getMessage());
    }
});



JButton p_addBtn = new JButton("Add To Cart");

//add to cart listener
p_addBtn.addActionListener(e -> {

    if(p_medicinePriceLabel.getText().isEmpty() || p_qtyField.getText().isEmpty()){
        JOptionPane.showMessageDialog(null,"Fill all fields!");
        return;
    }

    double price = Double.parseDouble(p_medicinePriceLabel.getText());
    int qty = Integer.parseInt(p_qtyField.getText());

    p_tableModel.addRow(new Object[]{
        p_supplierIdField.getText(),
        p_medicineIdField.getText(),
        p_medicineNameLabel.getText(),
        price,
        qty,
        price * qty
    });
});


JButton p_saveBtn = new JButton("Save Purchase");
JButton p_clearBtn = new JButton("Clear");
JButton backButtonPurchase= new JButton("Back");  
		backButtonPurchase.setBackground(Color.LIGHT_GRAY);  
		backButtonPurchase.setFont(font);  
		backButtonPurchase.setFocusPainted(false);  
		backButtonPurchase.setForeground(Color.BLACK);  
		backButtonPurchase.setPreferredSize(new Dimension(120,35));  
		backButtonPurchase.addActionListener(evv->{  
		card.show(panel,"dash");  
		});

JPanel p_medicinePanel = new JPanel(new GridLayout(0,2,10,10));
p_medicinePanel.setBackground(Color.BLACK);

JLabel p_m1 = new JLabel("Medicine ID"); p_m1.setForeground(Color.WHITE);
JLabel p_m2 = new JLabel("Name"); p_m2.setForeground(Color.WHITE);
JLabel p_m3 = new JLabel("Price"); p_m3.setForeground(Color.WHITE);
JLabel p_m4 = new JLabel("Quantity"); p_m4.setForeground(Color.WHITE);

p_medicinePanel.add(p_m1);
p_medicinePanel.add(p_medicineIdField);
p_medicinePanel.add(p_m2);
p_medicinePanel.add(p_medicineNameLabel);
p_medicinePanel.add(p_m3);
p_medicinePanel.add(p_medicinePriceLabel);
p_medicinePanel.add(p_m4);
p_medicinePanel.add(p_qtyField);
p_medicinePanel.add(p_searchMedicineBtn);
p_medicinePanel.add(p_addBtn);
p_medicinePanel.add(p_saveBtn);
p_medicinePanel.add(p_clearBtn);
p_medicinePanel.add(backButtonPurchase);

p_inputPanel.add(p_supplierPanel);
p_inputPanel.add(p_medicinePanel);

// ===== FIX LAYOUT =====
JPanel p_topPanel = new JPanel(new BorderLayout());
p_topPanel.setBackground(Color.BLACK);
p_topPanel.add(p_purchaseTitle, BorderLayout.NORTH);
p_topPanel.add(p_inputPanel, BorderLayout.CENTER);

p_purchasePanel.add(p_topPanel, BorderLayout.NORTH);

// ================= TABLE =================
String p_columns[] = {"Supplier ID","Medicine ID","Name","Price","Qty","Total"};
 p_tableModel = new DefaultTableModel(p_columns,0);
p_table = new JTable(p_tableModel);
p_purchasePanel.add(new JScrollPane(p_table), BorderLayout.CENTER);
p_saveBtn.addActionListener(e -> {

    Connection con = null;

    try {
    	if(p_supplierNameLabel.getText().isEmpty()){
    JOptionPane.showMessageDialog(null, "Search valid supplier first!");
    return;
}

        // Prevent empty purchase
        if (p_tableModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Cart is empty!");
            return;
        }

        con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/medical_store",
                "root",
                "12345"
        );

        con.setAutoCommit(false);

        // ================= CALCULATE TOTAL =================
        double totalAmount = 0;

        for (int i = 0; i < p_tableModel.getRowCount(); i++) {

            int qty = Integer.parseInt(p_tableModel.getValueAt(i, 4).toString());
            double price = Double.parseDouble(p_tableModel.getValueAt(i, 3).toString());

            totalAmount += qty * price;
        }

        // ================= INSERT PURCHASE =================
        PreparedStatement insert = con.prepareStatement(
                "INSERT INTO purchase(supplier_id, total_price, date) VALUES (?,?,NOW())",
                Statement.RETURN_GENERATED_KEYS
        );

        insert.setString(1, p_supplierIdField.getText());
        insert.setDouble(2, totalAmount);

        insert.executeUpdate();

        // ================= GET PURCHASE ID =================
        ResultSet rs = insert.getGeneratedKeys();

        int p_id = 0;
        if (rs.next()) {
            p_id = rs.getInt(1);
        }

        // ================= DETAILS =================
        PreparedStatement detail = con.prepareStatement(
                "INSERT INTO purchase_detail(purchase_id, medicine_id, quantity, price, total) VALUES (?,?,?,?,?)"
        );

        // ================= STOCK UPDATE =================
        PreparedStatement stock = con.prepareStatement(
                "UPDATE medicine SET quantity = quantity + ? WHERE medicine_id = ?"
        );

        for (int i = 0; i < p_tableModel.getRowCount(); i++) {

            String medId = p_tableModel.getValueAt(i, 1).toString();
            int qty = Integer.parseInt(p_tableModel.getValueAt(i, 4).toString());
            double price = Double.parseDouble(p_tableModel.getValueAt(i, 3).toString());
            double total = qty * price;

            detail.setInt(1, p_id);
            detail.setString(2, medId);
            detail.setInt(3, qty);
            detail.setDouble(4, price);
            detail.setDouble(5, total);

            detail.executeUpdate();

            stock.setInt(1, qty);
            stock.setString(2, medId);

            stock.executeUpdate();
        }

        // ================= COMMIT =================
        con.commit();

        // clear cart
        p_tableModel.setRowCount(0);

        // ================= 🔥 FIXED: PURCHASE HISTORY REFRESH =================
        try {

            // IMPORTANT FIX: USE MODEL, NOT getModel()
            purchaseHistoryModel.setRowCount(0);

            ResultSet rs2 = new PurchaseService().getPurchaseHistory();

            while (rs2.next()) {

                purchaseHistoryModel.addRow(new Object[]{
                        rs2.getInt("purchase_id"),
                        rs2.getString("supplier_id"),
                        rs2.getString("date")
                });
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        JOptionPane.showMessageDialog(null, "Purchase Saved Successfully!");

    } catch (Exception ex) {

        try {
            if (con != null) con.rollback();
        } catch (Exception e2) {
            e2.printStackTrace();
        }

        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, ex.getMessage());
    }
});

// CLEAR
p_clearBtn.addActionListener(e -> {
    p_supplierIdField.setText("");
    p_supplierNameLabel.setText("");

    p_medicineIdField.setText("");
    p_qtyField.setText("");
    p_medicineNameLabel.setText("");
    p_medicinePriceLabel.setText("");

    p_tableModel.setRowCount(0); // clear cart
});


//================== Purchase History Panel ==============

JPanel purchaseHistoryPanel = new JPanel(new BorderLayout());
purchaseHistoryPanel.setBackground(Color.BLACK);
panel.add(purchaseHistoryPanel, "purchaseHistory");

// ================= TITLE =================
JLabel purchaseHistoryLabel = new JLabel("Purchase History", JLabel.CENTER);
purchaseHistoryLabel.setForeground(Color.WHITE);
purchaseHistoryLabel.setFont(new Font("Segoe UI", Font.BOLD, 36));
purchaseHistoryPanel.add(purchaseHistoryLabel, BorderLayout.NORTH);

// ================= TABLE PANEL =================
JPanel purchaseTablePanel = new JPanel(new GridLayout(2, 1, 10, 10));
purchaseTablePanel.setBackground(Color.BLACK);
purchaseHistoryPanel.add(purchaseTablePanel, BorderLayout.CENTER);



// ================= PURCHASE TABLE =================
String purchaseCols[] = {"Purchase ID", "Supplier ID", "Date"};

 purchaseHistoryModel = new DefaultTableModel(purchaseCols, 0);
JTable purchaseHistoryTable = new JTable(purchaseHistoryModel);

// Style
purchaseHistoryTable.setBackground(Color.BLACK);
purchaseHistoryTable.setForeground(Color.WHITE);
purchaseHistoryTable.setGridColor(Color.GRAY);
purchaseHistoryTable.setSelectionBackground(Color.DARK_GRAY);
purchaseHistoryTable.setSelectionForeground(Color.WHITE);

purchaseHistoryTable.getTableHeader().setBackground(Color.BLACK);
purchaseHistoryTable.getTableHeader().setForeground(Color.WHITE);

JScrollPane purchaseScroll = new JScrollPane(purchaseHistoryTable);
purchaseScroll.getViewport().setBackground(Color.BLACK);

purchaseTablePanel.add(purchaseScroll);



// ================= PURCHASE DETAIL TABLE =================
String purchaseDetailCols[] = {
        "Purchase ID",
        "Medicine ID",
        "Name",
        "Price",
        "Qty",
        "Total"
};

DefaultTableModel purchaseDetailModel = new DefaultTableModel(purchaseDetailCols, 0);
JTable purchaseDetailTable = new JTable(purchaseDetailModel);

// Style
purchaseDetailTable.setBackground(Color.BLACK);
purchaseDetailTable.setForeground(Color.WHITE);
purchaseDetailTable.setGridColor(Color.GRAY);
purchaseDetailTable.setSelectionBackground(Color.DARK_GRAY);
purchaseDetailTable.setSelectionForeground(Color.WHITE);

purchaseDetailTable.getTableHeader().setBackground(Color.BLACK);
purchaseDetailTable.getTableHeader().setForeground(Color.WHITE);

JScrollPane purchaseDetailScroll = new JScrollPane(purchaseDetailTable);
purchaseDetailScroll.getViewport().setBackground(Color.BLACK);

purchaseTablePanel.add(purchaseDetailScroll);



//====================================================
//                 DATABASE LOAD
//====================================================

try {
    PurchaseService ps = new PurchaseService();

    ResultSet rs1 = ps.getPurchaseHistory();
    purchaseHistoryModel.setRowCount(0);

    while (rs1.next()) {
        purchaseHistoryModel.addRow(new Object[]{
            rs1.getInt("purchase_id"),
            rs1.getString("supplier_id"),
            rs1.getString("date")
        });
    }

    ResultSet rs2 = ps.getPurchaseDetails();
    purchaseDetailModel.setRowCount(0);

    while (rs2.next()) {
        purchaseDetailModel.addRow(new Object[]{
            rs2.getInt("purchase_id"),
            rs2.getString("medicine_id"),
            rs2.getString("name"),
            rs2.getDouble("price"),
            rs2.getInt("quantity"),
            rs2.getDouble("total")
        });
    }

} catch (Exception ex) {
    ex.printStackTrace();
}


// ================= BACK BUTTON =================
JButton purchaseBackButton = new JButton("Back");
purchaseBackButton.setBackground(Color.LIGHT_GRAY);
purchaseBackButton.setForeground(Color.BLACK);
purchaseBackButton.setFont(new Font("Segoe UI", Font.BOLD, 14));

purchaseHistoryPanel.add(purchaseBackButton, BorderLayout.SOUTH);

purchaseBackButton.addActionListener(e -> {
    card.show(panel, "dash");
});



button[5].addActionListener(ex->{
	card.show(panel,"sales");
	});


	button[6].addActionListener(ex -> {

    try {
        SalesService ss = new SalesService();

        // ===== SALES HISTORY =====
        if (salesHistoryModel != null) {
            salesHistoryModel.setRowCount(0);

            ResultSet rs1 = ss.getSalesHistory();

            while (rs1.next()) {
                salesHistoryModel.addRow(new Object[]{
                        rs1.getInt("sale_id"),
                        rs1.getString("customer_id"),
                        rs1.getString("date")
                });
            }
        }

        // ===== SALES DETAILS =====
        if (salesDetailModel != null) {
            salesDetailModel.setRowCount(0);

            ResultSet rs2 = ss.getSalesDetails();

            while (rs2.next()) {
                salesDetailModel.addRow(new Object[]{
                        rs2.getInt("sale_id"),
                        rs2.getInt("medicine_id"),
                        rs2.getString("name"),
                        rs2.getDouble("price"),
                        rs2.getInt("quantity"),
                        rs2.getDouble("total")
                });
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    card.show(panel, "salesHistory");
});
	panel.add(p_purchasePanel,"purchase");
button[7].addActionListener(e->{
	card.show(panel,"purchase");
});

button[8].addActionListener(e->{
	card.show(panel,"purchaseHistory");
});
}

}








