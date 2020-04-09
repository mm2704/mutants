package ar.com.mercadolibre.mutant.searchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import ar.com.mercadolibre.mutant.enums.LettersEnum;
import ar.com.mercadolibre.mutant.model.DnaDTO;

@Component
public class MutantSearcher {

	public final static Integer SAMEE_LETTERS_MUTANT = 4;
	
	
	/**
	 * Devuelve un booleano indicando si encontro gen mutante.
	 * @param dna
	 * @return
	 */
	public boolean searchMutant(DnaDTO dnaDto) {

		String[] dna = dnaDto.getDna();
    	Integer fileLength = dna.length;
    	Integer columnLength = dna[0].length();	
    	String[][] matrix = new String[columnLength][fileLength];
    	fillMatrix(dna, matrix, fileLength, columnLength);
		
    	return (searchForMutant(Arrays.asList(dna)) || searchVerticalMutant(matrix, fileLength, columnLength)
    	|| searchDiagonalMutant(matrix));
	}
	
    /**
     * devuelve True/false indicando si encontro gen mutante en las cadenas diagonales
     * @param matrix
     * @return
     */
	private static boolean searchDiagonalMutant(String[][] matrix) {
    	
		List<String> firstDiagonal = getDiagonalMatrix(matrix);
		List<String> secondDiagonal = reverseMatrix(matrix);
		return searchForMutant(firstDiagonal) || searchForMutant(secondDiagonal);
		
	}

	/**
	 * devuelve True/false indicando si encontro gen mutante en las cadenas verticales
	 * @param matrix
	 * @param fileLength
	 * @param columnLength
	 * @return
	 */
	private static boolean searchVerticalMutant(String[][] matrix, Integer fileLength, Integer columnLength) {
		List<String> dnaVertical = getVerticalsMatrix(matrix, fileLength, columnLength);
		return searchForMutant(dnaVertical);
	}

	/**
	 * devuelve True/false indicando si encontro gen mutante.
	 * @param dna
	 * @return
	 */
	private static boolean searchForMutant(List<String> dna) {
		boolean result = false;
    	for (int i = 0; i < dna.size(); i++) {
    		result = result || isFileMutant(dna.get(i));	
		}	
    	return result;
	}
    
	/**
     * Por cada coluna de la array dna, rellena la matriz
     * @param dna
     * @param matrix
     * @param fileLength
     * @param columnLength
     */
    public static void fillMatrix(String[] dna ,String[][] matrix, Integer fileLength, Integer columnLength) {
    	for (int i = 0; i < fileLength; i++) {
    		addColumn(dna[i], matrix, i);	
		}
    }
	
    /**
     * Por cada item pasado por la array, lo agrega a la matrix
     * @param fileToAdd
     * @param matrix
     * @param fileRepeater
     */
    public static void addColumn(String fileToAdd, String[][] matrix, Integer fileRepeater) {
    	for (int i = 0; i < fileToAdd.length(); i++) {
			matrix[fileRepeater][i] = Character.toString(fileToAdd.charAt(i));
		}
    }
    
    /**
     * Obtiene un arreglo de string de las matrices verticales
     * @param matrix
     * @param fileSize
     * @param columnSize
     * @return
     */
    public static List<String> getVerticalsMatrix(String[][] matrix, Integer fileSize, Integer columnSize) {
    	String[] result = new String[fileSize];
    	String columnStr = "";
    	for (int i = 0; i < fileSize; i++) {
	    	for (int j = 0; j < columnSize; j++) {
				columnStr = columnStr + matrix[j][i];
			}
	    	result[i] = columnStr;
	    	columnStr = "";
    	}
		return Arrays.asList(result);
    }
    
   /**
    * Obtiene la primr posicion para matriz diagonal
    * @param matrix
    */
    private static List<String> getDiagonalMatrix(String[][] matrix) {
    	List<String> result = new ArrayList<String>();
	   for (int i = matrix.length - 1; i > 0; i--) {
	   String temp = "";
	       for (int j = 0, x = i; x <= matrix.length - 1; j++, x++) {
	          temp = temp+matrix[x][j];
	          result.add(temp);
	       }
	   }
	
	
	   for (int i = 0; i <= matrix.length - 1; i++) {
	        String temp = "";
	        for (int j = 0, y = i; y <= matrix.length - 1; j++, y++) {
	        temp = temp+matrix[j][y];
	          result.add(temp);
	        }
	   }
	   return result;
    }
    
    /**
     * Obtiene la segunda posicion para matriz diagonal
     * @param matrix
     */
    private static List<String> reverseMatrix(String[][] matrix) {
    	for(int j = 0; j < matrix.length; j++){
    	    for(int i = 0; i < matrix[j].length / 2; i++) {
    	        String temp = matrix[j][i];
    	        matrix[j][i] = matrix[j][matrix[j].length - i - 1];
    	        matrix[j][matrix[j].length - i - 1] = temp;
    	    }
    	}
    	return getDiagonalMatrix(matrix);
    }
    
    
    /**
     * Busca las ocurrencias de cada fila si tiene mas de 4 caracteres iguales es mutante
     * @param file
     * @return
     */
    public static boolean isFileMutant(String file) {
		boolean result = false;
    	if(!file.isEmpty()) {
    		for (LettersEnum letter : LettersEnum.values()) {
				int count = StringUtils.countMatches(file, StringUtils.repeat(letter.name(), SAMEE_LETTERS_MUTANT));
					result = result || count >= 1;
    		}
    	}
		return result;
    }

}
