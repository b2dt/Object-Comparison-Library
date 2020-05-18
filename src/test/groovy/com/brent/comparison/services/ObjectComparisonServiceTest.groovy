package com.brent.comparison.services

import com.brent.comparison.fixtures.*
import com.brent.comparison.models.ChangeType
import com.brent.comparison.models.ChangeWrapper
import com.brent.comparison.models.FlatChange
import com.brent.comparison.testData.*
import com.brent.comparison.testData.policyDto.PolicyDTO
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.Test
import spock.lang.Shared
import spock.lang.Specification

class ObjectComparisonServiceTest extends Specification {
    @Shared
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    def "Test ChangeWrapper creation and Flatten functionality"() {
        setup:
            LowerBody lowerBody2 = LowerBodyFixture.aDefaultLowerBody()
                    .withThigh(ThighFixture.aDefaultThigh().withSize(3).build())
                    .withFeet(Arrays.asList(
                            FeetFixture.aDefaultFeet().withListIndex(1).withShoeSize(2).withToes(null)
                                    .build(),
                            FeetFixture.aDefaultFeet().withListIndex(2).withShoeSize(4).withToes(null)
                                    .build(),
                            FeetFixture.aDefaultFeet().withListIndex(3).withShoeSize(4).withToes(
                                    Arrays.asList(ToeFixture.aDefaultToe().withListIndex(1).build()))
                                    .build()))
                    .build()

            UpperBody upperBody2 = UpperBodyFixture.aDefaultUpperBody().withNailDescription("WEIRD LOOKING").withHasNail(true).build()
            upperBody2.getArms().get(0).setRelationToInsured(RelationToInsured.CHILD)
            upperBody2.getArms().get(0).setTan(false)
            Human human1 = HumanFixture.aDefaultHuman().build()
            Human human2 = HumanFixture.aDefaultHuman().withUpperBody(upperBody2).withGender("male2").withLowerBody(lowerBody2).build()
            human2.getUpperBody().getFace().getEyes().get(0).setEyeColor(EyeColor.GREEN)
            human2.getCharacteristics().put("NEW", "INPUT")
            human2.getUpperBody().getArms().get(0).fingers.get(0).setNailDescription("weird thang")
            human1.getCharacteristics().put("NEW2", "INPUT2")
            human2.getTestDetails().put("NEWTOE", ToeFixture.aDefaultToe().withToeLocation("UNDER YA HAND").build())
            human2.getTestDetails().put("NEWTOE2", ToeFixture.aDefaultToe().withToeLocation("UNDER YA HAND").build())
            human2.setNicknames(Arrays.asList("Bront", "Dino", "Nerd", "Nerd", "Nerd", "Haunter"))
            String human1Str = objectMapper.writeValueAsString(human1)
            String human2Str = objectMapper.writeValueAsString(human2)
        when:
            List<FlatChange> results = Compare.flatten(human1, human2)
            ChangeWrapper changeWrapper = Compare.diff(human1, human2)
        then:
            for (FlatChange change : results) {
                if (change.getChangeType() == ChangeType.ADDED) {
                    assert change.getOldValue() == null
                    assert change.getNewValue() != null
                } else if (change.getChangeType() == ChangeType.DELETED) {
                    assert change.getOldValue() != null
                    assert change.getNewValue() == null
                } else if (change.getChangeType() == ChangeType.CHANGED) {
                    assert change.getOldValue() != null
                    assert change.getNewValue() != null
                }
                if (change.getAnnotations().size() > 0) {
                    //Annotations that exist on non-directly-comparable objects will never show up in the FlatChange list. They should always exist in the ChangeWrapper though.
                    assert change.getAttributeName() == "gender" || change.getAttributeName() == "listIndex" || change.getAttributeName() == "size"
                }
            }
            results.size() == 49
    }

    def "test PolicyDTO changes"() {
        setup: "create objectMapper"
            ObjectMapper objectMapper1 = new ObjectMapper()
        and: "create objects"
            String dtoStr = TestData.getDtoStr()
            PolicyDTO policyDTO = objectMapper1.readValue(dtoStr, PolicyDTO.class);
            String dtoStr2 = TestData.getDtoStr2()
            PolicyDTO policyDTO2 = objectMapper1.readValue(dtoStr2, PolicyDTO.class);
        when:
            List<FlatChange> changes = Compare.flatten(policyDTO, policyDTO2);
        then:
            changes.size() == 8
    }
}