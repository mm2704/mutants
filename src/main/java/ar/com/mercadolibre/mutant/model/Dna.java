package ar.com.mercadolibre.mutant.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperFieldModel.DynamoDBAttributeType;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTyped;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "DNA")
public class Dna {

	
    @DynamoDBHashKey(attributeName = "DnaId")
    private String dnaId;
    
    @DynamoDBTyped(DynamoDBAttributeType.BOOL)
    @DynamoDBAttribute(attributeName="isMutant")
    private boolean isMutant;
    
}
