package com.example.demo.business.commons.validation;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({Default.class, SecondStageValidation.class})
public interface ValidationOrder {
}
