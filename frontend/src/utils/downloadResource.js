function downloadResources() {
  const text = 'https://www.youtube.com/watch?v=dQw4w9WgXcQ';
  const fileName = 'video_link.txt';

  // Create a blob with the text content
  const blob = new Blob([text], { type: 'text/plain' });

  // Create an <a> element
  const a = document.createElement('a');
  a.style.display = 'none';

  // Create a URL for the blob and set it as href for the <a> element
  const url = window.URL.createObjectURL(blob);
  a.href = url;
  a.download = fileName;

  // Append the <a> element to the document body
  document.body.appendChild(a);

  // Simulate a click on the <a> element to initiate download
  a.click();

  // Cleanup: remove the <a> element and revoke the URL object to free up memory
  document.body.removeChild(a);
  window.URL.revokeObjectURL(url);
}

export default downloadResources;
