import {
  Stack,
  FormControl,
  FormLabel,
  Input,
  Textarea,
  CardActions,
  Button,
  DialogTitle,
} from '@mui/joy';
import PropTypes from 'prop-types';
import { useState } from 'react';

export default function CompanyForm({ onSubmit, update, companyToUpdate }) {
  const [companyName, setCompanyName] = useState(
    update ? companyToUpdate.name : ''
  );
  const [addressLine1, setAddressLine1] = useState(
    update ? companyToUpdate.addressLine1 : ''
  );
  const [addressLine2, setAddressLine2] = useState(
    update ? companyToUpdate.addressLine2 : ''
  );
  const [contactEmail, setContactEmail] = useState(
    update ? companyToUpdate.contactEmail : ''
  );
  const [description, setDescription] = useState(
    update ? companyToUpdate.description : ''
  );

  const handleSubmit = (e) => {
    e.preventDefault();
    onSubmit({
      name: companyName,
      addressLine1,
      addressLine2,
      contactEmail,
      description,
    });
  };

  return (
    <Stack gap={1} minWidth="450px">
      <DialogTitle>{update ? 'Update Company' : 'Add New Company'}</DialogTitle>
      <FormControl size="lg">
        <FormLabel>Company Name</FormLabel>
        <Input
          value={companyName}
          onChange={(e) => setCompanyName(e.target.value)}
        />
      </FormControl>
      <FormControl size="lg">
        <FormLabel>Contact Email</FormLabel>
        <Input
          value={contactEmail}
          onChange={(e) => setContactEmail(e.target.value)}
        />
      </FormControl>
      <FormControl size="lg">
        <FormLabel>Description</FormLabel>
        <Textarea
          minRows={3}
          value={description}
          onChange={(e) => setDescription(e.target.value)}
        />
      </FormControl>
      <FormControl size="lg">
        <FormLabel>Address Line 1</FormLabel>
        <Input
          value={addressLine1}
          onChange={(e) => setAddressLine1(e.target.value)}
        />
      </FormControl>
      <FormControl size="lg">
        <FormLabel>Address Line 2</FormLabel>
        <Input
          value={addressLine2}
          onChange={(e) => setAddressLine2(e.target.value)}
        />
      </FormControl>
      <CardActions buttonFlex="0 1 1" orientation="horizontal-reverse">
        <Button onClick={handleSubmit} size="lg">
          Submit
        </Button>
      </CardActions>
    </Stack>
  );
}

CompanyForm.propTypes = {
  onSubmit: PropTypes.func.isRequired,
  update: PropTypes.bool,
  companyToUpdate: PropTypes.shape({
    name: PropTypes.string,
    addressLine1: PropTypes.string,
    addressLine2: PropTypes.string,
    contactEmail: PropTypes.string,
    description: PropTypes.string,
  }),
};
