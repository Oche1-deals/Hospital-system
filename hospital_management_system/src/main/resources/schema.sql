insert into patient ( DATE_OF_BIRTH,ID,ADDRESS,BLOOD_GROUP,EMAIL,EMERGENCY_CONTACT_NAME,
 EMERGENCY_CONTACT_PHONE,EMERGENCY_RELATION,FIRST_NAME,GENDER,LAST_NAME,PHONE_NUMBER)
 values(current_date(),1000, 'abuja', 'o', 'odoh@11', 'oche', 911, 'friend','raph', 'male', 'odoh', 674358);

 insert into patient ( DATE_OF_BIRTH,ID,ADDRESS,BLOOD_GROUP,EMAIL,EMERGENCY_CONTACT_NAME,
  EMERGENCY_CONTACT_PHONE,EMERGENCY_RELATION,FIRST_NAME,GENDER,LAST_NAME,PHONE_NUMBER)
  values(current_date(),1001, 'lagos', 'A', 'lucy@11', 'mike', 419, 'sister','david', 'female', 'ujah', 67400358);

  insert into patient ( DATE_OF_BIRTH,ID,ADDRESS,BLOOD_GROUP,EMAIL,EMERGENCY_CONTACT_NAME,
   EMERGENCY_CONTACT_PHONE,EMERGENCY_RELATION,FIRST_NAME,GENDER,LAST_NAME,PHONE_NUMBER)
   values(current_date(),1002, 'benue', 'B', 'jp@11', 'daniel', 619, 'wife','ben', 'male', 'otanwa', 67434118);


   insert into doctor( AVAILABILITY,DATE_OF_BIRTH,CREATED_AT,ID,ADDRESS,EMAIL,FIRST_NAME,
   GENDER,LAST_NAME,LICENSE_NUMBER,PHONE_NUMBER,SPECIALIZATION)
   values(true,current_date(), current_date(), 2000, 'kubwa', 'yes.com@mail', 'somto', 'male', 'james','111', 8756463,'cardiologist' );

   insert into doctor( AVAILABILITY,DATE_OF_BIRTH,CREATED_AT,ID,ADDRESS,EMAIL,FIRST_NAME,
      GENDER,LAST_NAME,LICENSE_NUMBER,PHONE_NUMBER,SPECIALIZATION)
      values(true,current_date(), current_date(), 2001, 'phase4', 'no.com@mail', 'samule', 'male', 'john','121', 87333463,'gynecologist' );

      insert into doctor( AVAILABILITY,DATE_OF_BIRTH,CREATED_AT,ID,ADDRESS,EMAIL,FIRST_NAME,
         GENDER,LAST_NAME,LICENSE_NUMBER,PHONE_NUMBER,SPECIALIZATION)
         values(true,current_date(), current_date(), 2002, 'wuse', 'favour.com@mail', 'favour', 'female', 'jane','134', 4983425,'Psychiatrist' );


insert into medical_record( CREATED_AT,DOCTOR_ID,PATIENT_ID,RECORD_ID,UPDATED_AT,DIAGNOSIS,
NOTES,TREATMENT)
values(current_date(),2000, 1000, 3000, current_date(), 'Angiography uses contrast media to X-ray image soft internal structures, such as arteries and veins.',
'patient is progressing', 'give injection');

insert into medical_record( CREATED_AT,DOCTOR_ID,PATIENT_ID,RECORD_ID,UPDATED_AT,DIAGNOSIS,
NOTES,TREATMENT)
values(current_date(),2001, 1001, 3001, current_date(), 'Angiography uses contrast media to X-ray image soft internal structures, such as arteries and veins.',
'patient is progressing slowly', '2 paracetamol');

insert into medical_record( CREATED_AT,DOCTOR_ID,PATIENT_ID,RECORD_ID,UPDATED_AT,DIAGNOSIS,
NOTES,TREATMENT)
values(current_date(),2002, 1002, 3002, current_date(), 'Angiography uses contrast media to X-ray image soft internal structures, such as arteries and veins.',
'patient is progressing with speed', 'antibiotics');


insert into appointment(DATE,TIME,APPOINTMENT_ID,CREATED_AT,DOCTOR_ID,PATIENT_ID,UPDATED_AT,
REASON,STATUS)
values(current_date(),current_time(),4000, current_date(),2000,1000,current_date(),'head ache','SCHEDULED');

insert into appointment(DATE,TIME,APPOINTMENT_ID,CREATED_AT,DOCTOR_ID,PATIENT_ID,UPDATED_AT,
REASON,STATUS)
values(current_date(),current_time(),4001, current_date(),2001,1001,current_date(),'stomach ache','SCHEDULED');

insert into appointment(DATE,TIME,APPOINTMENT_ID,CREATED_AT,DOCTOR_ID,PATIENT_ID,UPDATED_AT,
REASON,STATUS)
values(current_date(),current_time(),4002, current_date(),2002,1002,current_date(),'waist pain','SCHEDULED');


insert into prescription( ISSUED_DATE,VALID_UNTIL,DOCTOR_ID,PATIENT_ID,PRESCRIPTION_ID,
DOSAGE,MEDICATION_TEXT,STATUS)
values(current_date(),current_date(),2000,1000,5000,'2 drips', 'please follow consistently','ISSUED');

insert into prescription( ISSUED_DATE,VALID_UNTIL,DOCTOR_ID,PATIENT_ID,PRESCRIPTION_ID,
DOSAGE,MEDICATION_TEXT,STATUS)
values(current_date(),current_date(),2001,1001,5001,'1 drip', 'please follow weekly','ISSUED');

insert into prescription( ISSUED_DATE,VALID_UNTIL,DOCTOR_ID,PATIENT_ID,PRESCRIPTION_ID,
DOSAGE,MEDICATION_TEXT,STATUS)
values(current_date(),current_date(),2002,1002,5002,'2 kilograms', 'please follow','DISPENSED');