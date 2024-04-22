import tensorflow as tf
import pandas as pd
import numpy as np
import re

# Dummy comments
comments = [
    "This company is great. they have really understanding mentors and has a good environment. Overall my experience with the company is great"
]

df = pd.DataFrame({'Comments': comments})
comments = np.array(df['Comments'].values)

# Text Preprocessing
def clean_text(text):
    text = text.lower() # Convert text to lowercase
    text = re.sub(r'[^a-zA-Z\s]', '', text) # Remove special characters, punctuation, and numbers
    return text

cleaned_comments = [clean_text(comment) for comment in comments]

# Load Model
model = tf.saved_model.load('AI\model')

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

# Display Predictions
for comment, prediction in zip(comments, predictions):
    normalized_prediction = min_max_normalization(prediction)

    print("Comment:", comment)
    print("ProfessionalEnvironment: %.2f" % (normalized_prediction[0][0]*100), '%')
    print("NewKnowledge: %.2f" % (normalized_prediction[0][1]*100), '%')
    print("Selflearning: %.2f" % (normalized_prediction[0][2]*100), '%')
    print("IndustryExperience: %.2f" % (normalized_prediction[0][3]*100), '%')
    print("PleasantExperience: %.2f" % (normalized_prediction[0][4]*100), '%')
    print("GreatExperience: %.2f" % (normalized_prediction[0][5]*100), '%')
    print("GoodMentors: %.2f" % (normalized_prediction[0][6]*100), '%')
    print("SystemsDevelopment: %.2f" % (normalized_prediction[0][7]*100), '%')
    print("Allowance: %.2f" % (normalized_prediction[0][8]*100), '%')
    print("PoorHandling: %.2f" % (normalized_prediction[0][9]*100), '%')
    print("UnpleasantExperience: %.2f" % (normalized_prediction[0][10]*100), '%')
    print("ChallengingExperience: %.2f" % (normalized_prediction[0][11]*100), '%')
    print("WebDevelopment: %.2f" % (normalized_prediction[0][12]*100), '%')
    print("ProjectManagement: %.2f" % (normalized_prediction[0][13]*100), '%')
    print("GoodEnvironment: %.2f" % (normalized_prediction[0][14]*100), '%')
    print()