export async function getLiveData() {

  try {
    const response = await fetch('/api/live-data/get');
    return await response.json();
  } catch (error) {
    return [];
  }

}