import tensorflow as tf
import pandas as pd
import numpy as np
import re

def generate_tags(comments_data):
    return tags(comments_data)

def tags(comments_data):
    # feed a list of comments
    df = pd.DataFrame({'Comments': comments_data})
    comments = np.array(df['Comments'].values)

    # Text Preprocessing
    def clean_text(text):
        text = text.lower() # Convert text to lowercase
        text = re.sub(r'[^a-zA-Z\s]', '', text) # Remove special characters, punctuation, and numbers
        return text

    cleaned_comments = [clean_text(comment) for comment in comments]

    # Load Model
    model = tf.saved_model.load('/app/src/main/textclassifier/model')

    # Get the inference function from the loaded model
    inference = model.signatures["serving_default"]

    # Perform inference
    output = inference(tf.constant(cleaned_comments))

    # Assuming 'output' contains the dictionary with the TensorFlow tensor
    tensor_value = output['reshape']  # Accessing the tensor from the dictionary

    # Convert the TensorFlow tensor to a NumPy array
    output_array = tensor_value.numpy()

    # Extract predictions from the output
    predictions = output_array

    # Normalization Function
    def min_max_normalization(x):
        return (x - np.min(x)) / (np.max(x) - np.min(x))

    tags = []

    # Display Predictions
    for comment, prediction in zip(comments, predictions):
        print("Tags got")
        normalized_prediction = min_max_normalization(prediction)
        
        tag01 = normalized_prediction[0][0]*100
        tag02 = normalized_prediction[0][1]*100
        tag03 = normalized_prediction[0][2]*100
        tag04 = normalized_prediction[0][3]*100
        tag05 = normalized_prediction[0][4]*100
        tag06 = normalized_prediction[0][5]*100
        tag07 = normalized_prediction[0][6]*100
        tag08 = normalized_prediction[0][7]*100
        tag09 = normalized_prediction[0][8]*100
        tag10 = normalized_prediction[0][9]*100
        tag11 = normalized_prediction[0][10]*100
        tag12 = normalized_prediction[0][11]*100
        tag13 = normalized_prediction[0][12]*100
        tag14 = normalized_prediction[0][13]*100
        tag15 = normalized_prediction[0][14]*100

        if tag01 >= 50.0:
            if "Professional Environment" not in tags:
                tags.append("Professional Environment")
        if tag02 >= 50.0:
            if "New Knowledge" not in tags:
                tags.append("New Knowledge")
        if tag03 >= 50.0:
            if "Self Learning" not in tags:
                tags.append("Self Learning")
        if tag04 >= 50.0:
            if "Industry Experience" not in tags:
                tags.append("Industry Experience")
        if tag05 >= 50.0:
            if "Pleasant Experience" not in tags:
                tags.append("Pleasant Experience")
        if tag06 >= 50.0:
            if "Great Experience" not in tags:
                tags.append("Great Experience")
        if tag07 >= 50.0:
            if "Good Mentors" not in tags:
                tags.append("Good Mentors")
        if tag08 >= 50.0:
            if "Systems Development" not in tags:
                tags.append("Systems Development")
        if tag09 >= 50.0:
            if "Allowance" not in tags:
                tags.append("Allowance")
        if tag10 >= 50.0:
            if "Poor Handling" not in tags:
                tags.append("Poor Handling")
        if tag11 >= 50.0:
            if "Unpleasant Experience" not in tags:
                tags.append("Unpleasant Experience")
        if tag12 >= 50.0:
            if "Challenging Experience" not in tags:
                tags.append("Challenging Experience")
        if tag13 >= 50.0:
            if "Web Development" not in tags:
                tags.append("Web Development")
        if tag14 >= 50.0:
            if "Project Management" not in tags:
                tags.append("Project Management")
        if tag15 >= 50.0:
            if "Good Environment" not in tags:
                tags.append("Good Environment")
    
    return tags