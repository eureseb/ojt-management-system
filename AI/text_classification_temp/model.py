from tensorflow.keras.models import load_model

# Load Model
model = load_model(r'../model');

'''
# Make Predictions
predictions = model.predict(comments)

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
    print()'''