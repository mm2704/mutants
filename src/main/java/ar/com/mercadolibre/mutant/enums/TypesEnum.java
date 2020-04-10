package ar.com.mercadolibre.mutant.enums;

public enum TypesEnum {

	HUMAN("Human"),
	MUTANT("Mutant");
	

    public final String type;
 
    private TypesEnum(String type) {
        this.type = type;
    }
    
    public String getValue() {
        return type;
    }
}
