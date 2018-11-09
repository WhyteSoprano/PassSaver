import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Storage {
	
	private File file;
	private FileInputStream fin;
	private FileOutputStream fout;
	
	private Workbook wb;
	private Sheet s;
	private Row rowSite, rowUser, rowPass;
	
	private boolean newFile;
	
	public Storage () {
		
		if (new File ("Data").exists()) {
			
			JOptionPane.showMessageDialog(null, "Directory exists", "Message", 0);
		}
		else {
			
			new File ("Data").mkdirs();
			JOptionPane.showMessageDialog(null, "Directory doesn't exist", "Message", 0);			
		}
		
		file = new File ("Data/storage.xls");
		
		newFile = false;
		
		if (!file.exists()) {
			
			try {
				
				file.createNewFile();
				fin = new FileInputStream (file);
				wb = new HSSFWorkbook ();
				s = wb.createSheet();
				rowSite = s.createRow(0);
				rowUser = s.createRow(1);
				rowPass = s.createRow(2);
				fin.close();
				fout = new FileOutputStream (file);
				wb.write(fout);
				fout.close();
				wb.close();
				
				JOptionPane.showMessageDialog(null, "File doesn't exist. Created new file.", "Message", 0);	
			}
			catch (IOException e) {
				
				e.printStackTrace();
			}
			
			newFile = true;
		}
	}
	
	private void update () {
		
		try {
			
			fin = new FileInputStream (file);
			wb = WorkbookFactory.create(fin);
			s = wb.getSheetAt(0);
			rowSite = s.getRow(0);
			rowUser = s.getRow(1);
			rowPass = s.getRow(2);
			fin.close();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delete (int index) {
		
		update();
		rowSite.removeCell(rowSite.getCell(index));
		rowUser.removeCell(rowUser.getCell(index));
		rowPass.removeCell(rowPass.getCell(index));
		try {
			
			fout = new FileOutputStream (file);
			wb.write(fout);
			fout.close();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editSite (String siteOg, String siteNew) {
		
		update();
		int cellCount = rowSite.getPhysicalNumberOfCells();
		int cellToWrite = 0;
		boolean siteExists = false;
		
		for (int i = 0; i < cellCount; i++) {
			
			if (rowSite.getCell(i).getStringCellValue().equalsIgnoreCase(siteOg)) {
				
				cellToWrite = 1;
				siteExists = true;
			}
		}
		
		if (siteExists) {
			
			rowSite.getCell(cellToWrite).setCellValue(siteNew);
		}
		
		try {
			
			fout = new FileOutputStream (file);
			wb.write(fout);
			fout.close();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void save (String site, String user, String pass) {
		
		update ();
		int cellCount = rowSite.getPhysicalNumberOfCells();
		int cellToWrite = cellCount;
		boolean siteExists = false;
		
		for (int i = 0; i < cellCount; i++) {
			
			if (rowSite.getCell(i).getStringCellValue().equalsIgnoreCase(site)) {
				
				siteExists = true;
				cellToWrite = i;
				break;
			}
		}
		
		if (siteExists) {
			
			rowSite.getCell(cellToWrite).setCellValue(site);
			rowUser.getCell(cellToWrite).setCellValue(user);
			rowPass.getCell(cellToWrite).setCellValue(pass);
			System.out.println("Site exists");
		}
		else {
			
			rowSite.createCell(cellToWrite).setCellValue(site);
			rowUser.createCell(cellToWrite).setCellValue(user);
			rowPass.createCell(cellToWrite).setCellValue(pass);
			System.out.println("Site doesn't exist");
		}
		
		try {
			
			fout = new FileOutputStream (file);
			wb.write(fout);
			fout.close();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getSite (String site) {
		
		String aux = "";
		update();
		
		for (int i = 0; i < rowSite.getPhysicalNumberOfCells(); i++) {
			
			if (rowSite.getCell(i).getStringCellValue().equalsIgnoreCase(site)) {
				
				aux = rowSite.getCell(i).getStringCellValue();
				System.out.println("Got site");
				break;
			}
		}
		
		return aux;
	}
	
	public String getUser (String site) {
		
		String aux = "";
		update ();
		
		for (int i = 0; i < rowSite.getPhysicalNumberOfCells(); i++) {
			
			if (rowSite.getCell(i).getStringCellValue().equalsIgnoreCase(site)) {
				
				aux = rowUser.getCell(i).getStringCellValue();
				System.out.println("got user");
				break;
			}
		}
		
		return aux;
	}
	
	public String getPass (String site) {
		
		String aux = "";
		update ();
		for (int i = 0; i < rowSite.getPhysicalNumberOfCells(); i++) {
			
			if (rowSite.getCell(i).getStringCellValue().equalsIgnoreCase(site)) {
				
				aux = rowPass.getCell(i).getStringCellValue();
				System.out.println("got pass");
				break;
			}
		}
		
		return aux;
	}
	
	public String [] initialize () {
		
		update ();
		
		int cells = rowSite.getPhysicalNumberOfCells();
		
		String [] str = new String [cells];
		
		for (int i = 0; i < cells; i++) {
			
			str [i] = rowSite.getCell(i).getStringCellValue();
		}
		
		return str;
	}
	
	public boolean isNew () {
		
		return newFile;
	}
}
















