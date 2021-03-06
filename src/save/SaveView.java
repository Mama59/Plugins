package save;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import filter.FilterTextFiles;
import model.Model;

/**
 * 
 * open a file selection on a jfrmae
 *
 */
public class SaveView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFileChooser fileDialog;
	protected File selectedFile;
	protected Model model;
	protected FilterTextFiles filterText;
	public SaveView(Model mod) {
		model = mod;
		filterText = new FilterTextFiles();
	}
/**
 * Open a text file
 */
	public File doSave() 
	{
		if (fileDialog == null)
			fileDialog = new JFileChooser();
		
		fileDialog.setDialogTitle("Select File to be Saved");
		if(selectedFile == null)
		{
			fileDialog.setFileFilter(new FileNameExtensionFilter("TEXT FILES", "txt", "text"));
			int option = fileDialog.showSaveDialog(this);
			if (option != JFileChooser.APPROVE_OPTION)
				return null; // User canceled or clicked the dialog's close box.
			
		}
		else
		{
			fileDialog.setSelectedFile(selectedFile);
		}
		selectedFile = fileDialog.getSelectedFile();		
		BufferedWriter lecteurAvecBuffer=null;
		try {
			lecteurAvecBuffer = new BufferedWriter (new FileWriter(selectedFile));
			lecteurAvecBuffer.write(model.getMyString());
			lecteurAvecBuffer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return selectedFile;
	}
	public File doSave(File f) 
	{
		selectedFile = f;
		return doSave();
	}
	public File doSaveChange() 
	{
		return doSave(null);
	}
}
