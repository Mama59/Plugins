package open;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import filter.FilterTextFiles;
import model.Model;
import model.ModelModifier;

/**
 * 
 * open a file selection on a jfrmae
 *
 */
public class OpenView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFileChooser fileDialog;
	protected File file, editFile, selectedFile;
	protected Model model;
	protected FilterTextFiles filterText;
	protected ModelModifier modelModifier;
	public OpenView(Model mod, ModelModifier modifier) {
		model = mod;
		filterText = new FilterTextFiles();
		modelModifier = modifier;
	}
/**
 * Open a text file
 * @return File selectedFile
 */
	public File doOpen() 
	{
		if (fileDialog == null)
			fileDialog = new JFileChooser();
		
		fileDialog.setDialogTitle("Select File to be Opened");
		fileDialog.setSelectedFile(selectedFile);
		fileDialog.setFileFilter(new FileNameExtensionFilter("TEXT FILES", "txt", "text"));
		int option = fileDialog.showOpenDialog(this);
		if (option != JFileChooser.APPROVE_OPTION)
			return selectedFile; // User canceled or clicked the dialog's close box.
		selectedFile = fileDialog.getSelectedFile();
		BufferedReader lecteurAvecBuffer=null;
		String ligne;
		String text = "";
		try {
			lecteurAvecBuffer = new BufferedReader (new FileReader(selectedFile));
			while ((ligne = lecteurAvecBuffer.readLine())!=null)
			{
				text += ligne +"\n";
			}
			lecteurAvecBuffer.close();
			modelModifier.changeModel(text);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return selectedFile;
	}
}
