package sortingUI;

import titlesUI.TitleFrameApp;
import access.DAO;
import access.SAHIAccess;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import linked_list.SortableLinkedList;
import searchSort.SearchSortInterface;
import text.TextFileInterface;

/**
 *
 * @author Kelvin Bonilla
 */
public class OutputSortResultsFrame extends javax.swing.JFrame
{
    private javax.swing.JFrame previousWindow;
    private ArrayList<String> sortChoices;
    private ArrayList<int[]> indicesChosen;
    private ArrayList<SearchSortInterface> sortOutputInfo;    
    private ArrayList<SAHIAccess> arrayHolders;
    private ArrayList<Integer> numElements; // number of elements for each sort
    private ArrayList<DAO.Order> orders; // order chosen for each sort
    private ArrayList<TextFileInterface> dataAccess; // a bunch of DAO's for access to difference text files
    private ArrayList<Boolean> isArray; // whether the implementation of each sort is array-based or linked-list based
    private ArrayList<SortableLinkedList> linkedLists;
    
    private final int HUNDRED = 0;
    private final int THOUSAND = 1;
    private final int TEN_THOUSAND = 2;
    
    private final int IN_ORDER = 0;
    private final int REVERSE_ORDER = 1;
    private final int RANDOM_ORDER = 2;
    
    
    /**
     * Creates new form CheckDataFrame
     */
    public OutputSortResultsFrame(javax.swing.JFrame previousWindow, ArrayList<String> sortChoicesList, ArrayList<int[]> indicesChosen) {
        this.previousWindow = previousWindow;
        this.sortChoices = sortChoicesList;
        this.indicesChosen = indicesChosen;
        this.sortOutputInfo = new ArrayList<>();
        this.arrayHolders = new ArrayList<>();
        this.numElements = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.dataAccess = new ArrayList<>();
        this.isArray = new ArrayList<>();
        this.linkedLists = new ArrayList<>();
        
        for(int i = 0; i < sortChoicesList.size(); i++) // initialize arrayLists with null vals
        {
            sortOutputInfo.add(i, null);
            arrayHolders.add(i, null);
            numElements.add(i, null);
            orders.add(i, null);
            dataAccess.add(i, null);
            linkedLists.add(i, null);
        }
        
        long duration;
        
        for(int i = 0; i < sortChoices.size(); i++)
        {
            numElements.add(i, getNumElements(indicesChosen.get(i))); // get the number of elements the sort is going to use
            orders.add(i, getOrder(indicesChosen.get(i))); // get the order that the values are organized in
            isArray.add(i, isArrayBased(sortChoices.get(i))); // add bool representing whether that sort is array or linked-list based
            dataAccess.add(i, DAO.createTextFile(numElements.get(i), orders.get(i))); // create txt file
            
            if(isArray.get(i))
                arrayHolders.add(i, DAO.getComparableArrayHolder(dataAccess.get(i).getArray())); // create comparable array holder with data from text file
            else
                linkedLists.add(i, dataAccess.get(i).getLinkedList());
            
            if(isArray.get(i))
                duration = sort(arrayHolders.get(i), getSortFromString(sortChoices.get(i))); // gets sort from sortChoices, passes that sort and the array holder to be sorted
            else
                duration = sort(linkedLists.get(i), getSortFromString(sortChoices.get(i)));
            
            if(isArray.get(i))
                sortOutputInfo.add(i, DAO.getSortInfoHolder(getSortFromString(sortChoices.get(i)), getImplementationName(i), "Integer", numElements.get(i), duration, "milli-seconds", arrayHolders.get(i).getSortComparisons())); // create sort info holder and add it
            else
                sortOutputInfo.add(i, DAO.getSortInfoHolder(getSortFromString(sortChoices.get(i)), getImplementationName(i), "Integer", numElements.get(i), duration, "milli-seconds", linkedLists.get(i).getSortComparisons())); // create sort info holder and add it
            
            dataAccess.get(i).writeToOutput(sortOutputInfo.get(i)); // writing to output file
        }
        initComponents();
        fillComboBox(sortChoices);
        
    }
    
    private void fillComboBox(ArrayList<String> theSorts)
    {
        String[] splitted;
        for(int i = 0; i < theSorts.size(); i++)
        {
            splitted = theSorts.get(i).split(" | ");
            if(splitted[2].equalsIgnoreCase("linked-list"))
                sortsComboBox.addItem(theSorts.get(i));
            else
                sortsComboBox.addItem(splitted[0]);
        }
    }
    
    private int getNumElements(int[] indicesChosen)
    {
        int numOfElements = indicesChosen[0];
        
        switch (numOfElements)
        {
            case HUNDRED:
                return 100;
            case THOUSAND:
                return 1000;
            case TEN_THOUSAND:
                return 10000;
            default:
                return 100;
        }
    }
    
    private DAO.Order getOrder(int[] indicesChosen)
    {
        int orderNum = indicesChosen[1];
        switch(orderNum)
        {
            case IN_ORDER:
                return DAO.Order.IN_ORDER;
            case REVERSE_ORDER:
                return DAO.Order.REVERSE_ORDER;
            case RANDOM_ORDER:
                return DAO.Order.RANDOM;
            default:
                return DAO.Order.RANDOM;
        }
    }
    
    private Boolean isArrayBased(String theSort)
    {
        String[] sort = theSort.split(" | ");
        String implString = sort[2];
        return (implString.equalsIgnoreCase("Array"));
    }
    
    private String getImplementationName(int index)
    {
        if(isArray.get(index))
            return "Array";
        else
            return "Linked-List";
    }
    
    private DAO.SortType getSortFromString(String theSort)
    {
        String[] sort = theSort.split(" | ");
        if(sort[0].equalsIgnoreCase("selection"))
            return DAO.SortType.SELECTION;
        else if(sort[0].equalsIgnoreCase("bubble"))
            return DAO.SortType.BUBBLE;
        else if(sort[0].equalsIgnoreCase("insertion"))
            return DAO.SortType.INSERTION;
        else if(sort[0].equalsIgnoreCase("merge"))
            return DAO.SortType.MERGE;
        else if(sort[0].equalsIgnoreCase("quick"))
            return DAO.SortType.QUICK;
        else if(sort[0].equalsIgnoreCase("heap"))
            return DAO.SortType.HEAP;
        return null;
    }
    
    private long sort(SAHIAccess toSort, DAO.SortType sortType) // returns duration in milli-seconds
    {
        long startTime = System.currentTimeMillis();
        toSort.sort(sortType);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        return duration;
    }
    
    private long sort(SortableLinkedList toSort, DAO.SortType sortType)
    {
        long startTime = System.currentTimeMillis();
        toSort.sort(sortType);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        return duration;
    }
    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameSelectionLbl = new javax.swing.JLabel();
        outputLbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputTxtArea = new javax.swing.JTextArea();
        backBtn = new javax.swing.JButton();
        sortsComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Data Check");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                windowClosingEvt(evt);
            }
        });

        nameSelectionLbl.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        nameSelectionLbl.setText("Sort Selection:");
        nameSelectionLbl.setToolTipText("The sort that was previously selected.");

        outputLbl.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        outputLbl.setText("Output:");
        outputLbl.setToolTipText("The contents of the stored data");

        outputTxtArea.setEditable(false);
        outputTxtArea.setColumns(20);
        outputTxtArea.setLineWrap(true);
        outputTxtArea.setRows(5);
        outputTxtArea.setToolTipText("Displaying the contents of the data previously chosen");
        outputTxtArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(outputTxtArea);

        backBtn.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        backBtn.setText("Back");
        backBtn.setToolTipText("Closes this window and brings you back to the Main Menu");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        sortsComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                sortsComboBoxItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(outputLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameSelectionLbl)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 165, Short.MAX_VALUE)
                                .addComponent(backBtn))
                            .addComponent(sortsComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameSelectionLbl)
                    .addComponent(sortsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outputLbl))
                .addGap(16, 16, 16)
                .addComponent(backBtn)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void windowClosingEvt(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_windowClosingEvt
        backBtn.doClick();
    }//GEN-LAST:event_windowClosingEvt

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        TitleFrameApp.displayFrame(previousWindow, this);
        dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void sortsComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_sortsComboBoxItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED)
        {
            int index = sortsComboBox.getSelectedIndex();
            if(index > sortChoices.size() || index == sortChoices.size())
            {
                outputTxtArea.setText("");
            }
            else if(index == 0)
            {
                if(sortChoices.size() <= 0)
                    outputTxtArea.setText("");
                else
                    outputTxtArea.setText(sortOutputInfo.get(index).toString());
            }
            else if(index < sortChoices.size() && index != -1)
            {
                outputTxtArea.setText(sortOutputInfo.get(index).toString());
            }
        }
        else if(evt.getStateChange() == ItemEvent.DESELECTED && sortsComboBox.getSelectedIndex() == -1)
        {
            outputTxtArea.setText("");
        }
    }//GEN-LAST:event_sortsComboBoxItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameSelectionLbl;
    private javax.swing.JLabel outputLbl;
    private javax.swing.JTextArea outputTxtArea;
    private javax.swing.JComboBox<String> sortsComboBox;
    // End of variables declaration//GEN-END:variables
}
